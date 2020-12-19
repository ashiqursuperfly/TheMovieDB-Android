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

    /*
        @GET(Const.Api.ENDPOINTS.GET_PICKING_ORDER_LIST)
        fun getPickingList(@Query(Const.Api.Params.GET.LIMIT) limit: Int): Flowable<AllOrdersResponse>

        @GET(Const.Api.ENDPOINTS.GET_PACKING_ORDER_LIST)
        fun getPackingList(@Query(Const.Api.Params.GET.LIMIT) limit: Int): Flowable<AllOrdersResponse>

        @GET
        fun getOrderDetails(@Url url:String): Flowable<OrderDetailsResponse>

        @FormUrlEncoded
        @POST(Const.Api.ENDPOINTS.LIST_VALIDATION)
        fun validateList(
        @Field(Const.Api.Params.POST.OPERATION_TYPE) operationType: String,
        @Field(Const.Api.Params.POST.ID) orderId: String,
        @Field(Const.Api.Params.POST.PRODUCTS_ARRAY) products: JSONArray
        ): Flowable<PackingValidationResponse>

        @FormUrlEncoded
        @POST(Const.Api.ENDPOINTS.CHANGE_ORDER_STATE)
        fun changeState(
        @Field(Const.Api.Params.POST.OPERATION_TYPE) operationType: String,
        @Field(Const.Api.Params.POST.ID) id: String
        ): Flowable<SimpleResponse>

        @FormUrlEncoded
        @POST(Const.Api.ENDPOINTS.ISSUE_IN_PACK)
        fun issueInPack(@Field(Const.Api.Params.POST.ID) orderId: String): Flowable<SimpleResponse>

    */

}