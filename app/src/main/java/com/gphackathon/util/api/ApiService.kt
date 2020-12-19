package com.gphackathon.util.api

import com.gphackathon.data.Const
import com.gphackathon.data.response.PopularMoviesResponse
import com.gphackathon.data.response.PopularTVSeriesResponse
import com.gphackathon.data.response.TrendingContentResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/6/20.
*/

interface ApiService {

    @GET(Const.Api.EndPoints.GET_POPULAR_MOVIES)
    fun getPopularMovies(
        @Query(Const.Api.Params.API_KEY) apiKey: String,
        @Query(Const.Api.Params.RELEASE_YEAR) year: String,
        @Query(Const.Api.Params.SORT_BY) sortBy: String
    ): Flowable<PopularMoviesResponse>

    @GET(Const.Api.EndPoints.GET_POPULAR_TV_SERIES)
    fun getPopularTvSeries(
        @Query(Const.Api.Params.API_KEY) apiKey: String,
        @Query(Const.Api.Params.RELEASE_YEAR) year: String,
        @Query(Const.Api.Params.SORT_BY) sortBy: String
    ): Flowable<PopularTVSeriesResponse>

    @GET(Const.Api.EndPoints.GET_TRENDING_CONTENT)
    fun getTrendingContents(
        @Query(Const.Api.Params.API_KEY) apiKey: String
    ): Flowable<TrendingContentResponse>

}