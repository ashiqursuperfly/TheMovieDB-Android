package com.gphackathon.data.response

import com.gphackathon.data.models.MovieData

data class PopularMoviesResponse(
    val page: Int,
    val results: List<MovieData>,
    val total_pages: Int,
    val total_results: Int
)