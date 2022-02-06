package com.brand.projectd.data.repositories

import com.brand.projectd.data.TrackDao
import com.brand.projectd.data.models.Track
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TrackRepository @Inject constructor(private val trackDao: TrackDao) {

    val getAllTracks: Flow<List<Track>> = trackDao.getAllTracks()

    fun getSelectedTrack(trackId: Int): Flow<Track> {
        return trackDao.getSpecificTrack(trackId = trackId)
    }

    fun searchTrackDatabase(query: String): Flow<List<Track>> {
        return trackDao.searchDatabase(searchQuery = query)
    }

    suspend fun addTrack(track: Track) {
        trackDao.addNewTrack(newTrack = track)
    }

    suspend fun updateTrack(track: Track) {
        trackDao.updateTrack(track = track)
    }

    suspend fun removeTrack(track: Track) {
        trackDao.removeTrack(track = track)
    }

    suspend fun removeAllTracks() {
        trackDao.removeAllTracks()
    }
}