
import com.example.music.DeezerApiService
import com.example.music.Track
import com.example.music.TrackDao

class MusicRepository(private val api: DeezerApiService, private val trackDao: TrackDao) {
    suspend fun getChartTracks(): List<Track> = api.getChartTracks().body() ?: emptyList()
    suspend fun searchTracks(query: String): List<Track> = api.searchTracks(query).body() ?: emptyList()
    suspend fun getLocalTracks(): List<Track> = trackDao.getAllTracks()
    suspend fun saveTrack(track: Track) = trackDao.insertTrack(track)
}