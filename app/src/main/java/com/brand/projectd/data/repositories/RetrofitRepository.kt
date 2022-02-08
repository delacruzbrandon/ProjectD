package com.brand.projectd.data.repositories

import com.brand.projectd.data.models.ApiResult
import com.brand.projectd.data.models.Track
import com.brand.projectd.data.service.TrackService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class RetrofitRepository @Inject constructor(private val trackService: TrackService) {

    suspend fun getApiResult(): ApiResult =
        withContext(Dispatchers.IO) {
            trackService.getApiResult()
        }

//    suspend fun getSelectedTrack(trackId: Int): Track = TODO
//        withContext(Dispatchers.IO) {
//            trackService.getApiResult().results[trackId]
//        }

//    fun getFlowSelectedTrack(trackId: Int): Flow<Track> { TODO
//        return trackService.getFlowApiResult()
//    }
}