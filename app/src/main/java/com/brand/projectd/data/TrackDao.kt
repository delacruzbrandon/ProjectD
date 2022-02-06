package com.brand.projectd.data

import androidx.room.*
import com.brand.projectd.data.models.Track
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDao {
    /** SELECT EVERYTHING(*) FROM track_table in ASCENDING(ASC) ORDER by id  */
    @Query("SELECT * FROM track_table ORDER BY id ASC")
    fun getAllTracks(): Flow<List<Track>>

    /** SELECT EVERYTHING(*) FROM track_table WHERE the id is equal to [trackId]*/
    @Query("SELECT * FROM track_table WHERE id=:trackId")
    fun getSpecificTrack(trackId: Int): Flow<Track>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTrack(newTrack: Track)

    @Update
    suspend fun updateTrack(track: Track)

    @Delete
    suspend fun removeTrack(track: Track)

    /** DELETE EVERYTHING FROM track_table */
    @Query("DELETE FROM track_table")
    suspend fun removeAllTracks()

    /** SELECT EVERYTHING(*) FROM track_table WHERE the title OR description is alike to [searchQuery]*/
    @Query("SELECT * FROM track_table WHERE name LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<Track>>

}