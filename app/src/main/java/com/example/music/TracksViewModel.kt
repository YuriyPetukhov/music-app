package com.example.music

import MusicRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TracksViewModel(private val repository: MusicRepository) : ViewModel() {
    private val _tracks = MutableLiveData<List<Track>>()
    val tracks: LiveData<List<Track>> = _tracks

    fun loadChartTracks() {
        viewModelScope.launch {
            _tracks.value = repository.getChartTracks()
        }
    }
}

class PlayerViewModel : ViewModel() {
    private val _currentTrack = MutableLiveData<Track?>()
    val currentTrack: LiveData<Track?> = _currentTrack

    fun playTrack(track: Track) {
        _currentTrack.value = track
    }
}