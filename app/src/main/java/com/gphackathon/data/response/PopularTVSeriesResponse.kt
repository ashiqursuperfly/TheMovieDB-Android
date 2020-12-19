package com.gphackathon.data.response

import com.gphackathon.data.models.TvSeriesData

data class PopularTVSeriesResponse(
    val page: Int,
    val results: List<TvSeriesData>,
    val total_pages: Int,
    val total_results: Int
)