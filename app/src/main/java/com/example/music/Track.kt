    package com.example.music

    import androidx.room.Entity
    import androidx.room.PrimaryKey

    @Entity(tableName = "tracks")
    data class Track(
        @PrimaryKey val id: Long,
        val title: String,
        val artist: String,
        val album: String?,
        val coverUrl: String?,
        val previewUrl: String?,
        val duration: Int
    )
