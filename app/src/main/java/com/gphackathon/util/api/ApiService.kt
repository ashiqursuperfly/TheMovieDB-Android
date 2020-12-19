package com.gphackathon.util.api

import com.gphackathon.data.Const
import io.reactivex.Flowable
import retrofit2.http.GET


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/6/20.
*/

interface ApiService {

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