package com.brand.projectd.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brand.projectd.data.models.Track

@Database(
    entities = [Track::class],
    version = 1,
    exportSchema = false
)
abstract class TrackDatabase: RoomDatabase() {

    abstract fun trackDao(): TrackDao
}