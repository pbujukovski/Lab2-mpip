package com.example.movieapp.repository

import com.example.movieapp.api.ApiService
import javax.inject.Inject

class MoviesRepository
    @Inject
    constructor(private val apiService: ApiService){
    suspend fun getMovies() = apiService.getMovies()
}
