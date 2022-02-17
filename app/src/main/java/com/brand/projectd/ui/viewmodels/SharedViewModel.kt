package com.brand.projectd.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.brand.projectd.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.brand.projectd.data.models.Track
import com.brand.projectd.data.repositories.RetrofitRepository
import com.brand.projectd.data.repositories.TrackRepository
import com.brand.projectd.di.ApiModule.provideApiService
import com.brand.projectd.di.ApiModule.provideRetrofit
import com.brand.projectd.di.ApiModule.providesRepository
import com.brand.projectd.util.Action
import com.brand.projectd.util.Action.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.internal.concurrent.Task
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val retrofitRepository: RetrofitRepository,
    private val trackRepository: TrackRepository
): ViewModel() {

    val action: MutableState<Action> = mutableStateOf(NO_ACTION)

    val id: MutableState<Int> = mutableStateOf(0)
    val name: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("No Description.")
    val image: MutableState<String> = mutableStateOf("")
    val price: MutableState<String> = mutableStateOf("")
    val genre: MutableState<String> = mutableStateOf("")

    private val _trackList = MutableStateFlow<RequestState<List<Track>>>(RequestState.Idle)
    val trackList: StateFlow<RequestState<List<Track>>> = _trackList

    private val _selectedTrack = MutableStateFlow<RequestState<Track>>(RequestState.Idle)
    val selectedTrack: StateFlow<RequestState<Track>> = _selectedTrack

    private val _currentScreen = MutableStateFlow("")
    val currentScreen: StateFlow<String> = _currentScreen

    init {
        providesRepository(
            provideApiService(
                provideRetrofit()
            )
        )
    }

    fun setTrackList() {
        if (_trackList.value is RequestState.Idle)
            _trackList.value = RequestState.Loading

        try {
            viewModelScope.launch {
                _trackList.value = RequestState.Success(
                    returnTrackList()
                )
            }
        } catch (e: Exception) {
            _trackList.value = RequestState.Error(e)
        }
    }

    fun setSelectedTrack(id: Int) {
        _selectedTrack.value = RequestState.Loading

        viewModelScope.launch {
            _selectedTrack.value = RequestState.Success(
                returnSelectedTrack(id)
            )
        }
    }

    fun handleDatabaseAction(action: Action) {
        when(action) {
            ADD -> { addTrack() }
            UNDO -> {}
            UPDATE -> {}
            REMOVE -> {}
            REMOVE_ALL -> {}
            NO_ACTION -> {}
        }
        this.action.value = NO_ACTION
    }

    private fun addTrack() {
        viewModelScope.launch(Dispatchers.IO) {
            val track = Track(
                id = id.value,
                name = name.value,
                description = description.value,
                image = image.value,
                price = price.value,
                genre = genre.value
            )
            trackRepository.addTrack(track = track)
        }
    }

    private suspend fun returnSelectedTrack(id: Int): Track {
        return retrofitRepository.getTrackSelected(id)
    }

    private suspend fun returnTrackList(): List<Track> {
        return retrofitRepository.getTrackList()
    }
}