package com.brand.projectd.data.repositories

import com.brand.projectd.data.models.Track
import com.brand.projectd.data.service.TrackService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class RetrofitRepository @Inject constructor(private val trackService: TrackService) {

    suspend fun getTrackList(): List<Track> =
        withContext(Dispatchers.IO) {
            trackService.getResultList().trackList
        }

    suspend fun getTrackSelected(id: Int): Track =
        withContext(Dispatchers.IO) {
            trackService.getResultSelected(id).trackList[0]
        }
}