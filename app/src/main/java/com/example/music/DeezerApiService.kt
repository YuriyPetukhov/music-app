package com.example.music

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface DeezerApiService {
    @GET("/chart")
    suspend fun getChartTracks(): Response<List<Track>>

    @GET("/search")
    suspend fun searchTracks(@Query("q") query: String): Response<List<Track>>

    @GET("/track/{id}")
    suspend fun getTrackDetails(@Path("id") id: Long): Response<Track>
}