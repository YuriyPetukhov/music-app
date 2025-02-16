package com.example.music

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase

@Dao
interface TrackDao {
    @Query("SELECT * FROM tracks")
    suspend fun getAllTracks(): List<Track>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrack(track: Track)
}

@Database(entities = [Track::class], version = 1)
abstract class LocalTrackDatabase : RoomDatabase() {
    abstract fun trackDao(): TrackDao
}