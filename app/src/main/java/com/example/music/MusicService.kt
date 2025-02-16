package com.example.music

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MusicService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: Реализовать фоновый плеер
        return START_STICKY
    }
}