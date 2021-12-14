package com.example.movieapp.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.models.MoviesItem
import com.example.movieapp.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


    @HiltViewModel
    class MoviesViewModel
    @Inject
    constructor(private val repository: MoviesRepository) : ViewModel() {

        private val _response = MutableLiveData<List<MoviesItem>>()
        val responseMovies: LiveData<List<MoviesItem>>
            get() = _response

        init {
            getAllMovies()
        }

        private fun getAllMovies() = viewModelScope.launch {
            repository.getMovies().let { response ->

                if (response.isSuccessful) {
                    _response.postValue(response.body())
                } else {
                    Log.d("tag", "getAllMovies Error: ${response.code()}")
                }
            }
        }


    }














