package com.example.movieapp.api

import com.example.movieapp.constants.Constants
import com.example.movieapp.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getMovies():Response<MoviesResponse>
}