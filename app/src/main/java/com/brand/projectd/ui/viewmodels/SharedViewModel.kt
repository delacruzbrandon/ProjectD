package com.brand.projectd.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.brand.projectd.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.brand.projectd.data.models.Track
import com.brand.projectd.data.repositories.RetrofitRepository
import com.brand.projectd.di.ApiModule.provideApiService
import com.brand.projectd.di.ApiModule.provideRetrofit
import com.brand.projectd.di.ApiModule.providesRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val retrofitRepository: RetrofitRepository
): ViewModel() {

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

    private suspend fun returnSelectedTrack(id: Int): Track {
        return retrofitRepository.getTrackSelected(id)
    }

    private suspend fun returnTrackList(): List<Track> {
        return retrofitRepository.getTrackList()
    }
}