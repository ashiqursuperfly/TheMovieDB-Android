package com.gphackathon.data.models

import com.gphackathon.data.Const

data class MovieData(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Int,
    val vote_count: Int
) {
    fun getPosterImageUrl(): String {
        return Const.Api.BASE_POSTER_IMAGE + poster_path
    }

    interface OnClick {
        fun onClick(movieData: MovieData)
    }
}