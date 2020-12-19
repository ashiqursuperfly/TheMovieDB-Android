package com.gphackathon.data.models

import com.gphackathon.data.Const

data class TvSeriesData(
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Float,
    val vote_count: Int
) {
    fun getPosterImageUrl(): String {
        return Const.Api.BASE_POSTER_IMAGE + poster_path
    }

    interface OnClick {
        fun onClick(seriesData: TvSeriesData)
    }
}