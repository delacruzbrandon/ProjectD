package com.brand.projectd.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.brand.projectd.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.brand.projectd.data.models.ApiResult
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

    private val _apiResult = MutableLiveData<ApiResult>()
    val apiResult: LiveData<ApiResult> = _apiResult

    private val _trackList = MutableStateFlow<RequestState<List<Track>>>(RequestState.Idle)
    val trackList: StateFlow<RequestState<List<Track>>> = _trackList

    private val _selectedTrack = MutableStateFlow<RequestState<Track>>(RequestState.Idle)
    val selectedTrack: StateFlow<RequestState<Track>> = _selectedTrack

    init {
        providesRepository(
            provideApiService(
                provideRetrofit()
            )
        )
    }

    fun getApis() {
        _trackList.value = RequestState.Loading

        viewModelScope.launch {
            _apiResult.value = getApiResults()
            getAllTracks()
        }
    }

//    fun getTrack(trackId: Int) { TODO
//        viewModelScope.launch {
//            retrofitRepository.getSelectedTrack(trackId = trackId)
//        }
//    }

    private fun getAllTracks() {
        try {
            viewModelScope.launch {
                _trackList.value = RequestState.Success(_apiResult.value!!.results)
            }
        } catch (e: Exception) {
            _trackList.value = RequestState.Error(e)
        }
    }

//    private fun getSelectedTrack(trackId: Int) { TODO
//        try {
//            viewModelScope.launch {
//                retrofitRepository.getSelectedTrack(trackId = trackId)
//            }
//        } catch (e: Exception) {
//            _selectedTrack.value = RequestState.Error(e)
//        }
//    }

    private suspend fun getApiResults(): ApiResult {
        return retrofitRepository.getApiResult()
    }
}