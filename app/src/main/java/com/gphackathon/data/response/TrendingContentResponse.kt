package com.gphackathon.data.response

import com.gphackathon.data.models.TrendingContent

data class TrendingContentResponse(
    val page: Int,
    val results: List<TrendingContent>,
    val total_pages: Int,
    val total_results: Int
)