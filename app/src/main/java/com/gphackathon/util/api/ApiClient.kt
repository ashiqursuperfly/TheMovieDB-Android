package com.gphackathon.util.api

import com.gphackathon.GpApp
import com.gphackathon.data.Const
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/6/20.
*/

object ApiClient {

    object OkHttpInterceptor {

        val interceptor = Interceptor { chain ->

            val request = chain.request().newBuilder()
            /*
            .addHeader(Const.Api.Params.HEADER.APP_VERSION, BuildConfig.VERSION_NAME)
            .addHeader(Const.Api.Params.HEADER.APP_VERSION_CODE, BuildConfig.VERSION_CODE.toString())
            */

/*
            val token = PrefUtil.get(Const.PrefProp.TOKEN,"-1")

            if(token != "-1"){
                request.addHeader(Const.Api.Params.HEADER.AUTHORIZATION, "Bearer $token")
            }
*/

            chain.proceed(request.build())
        }
    }

    private val client = OkHttpClient.Builder()
            .addInterceptor(OkHttpInterceptor.interceptor)
            .addInterceptor(ChuckInterceptor(GpApp.getApplicationContext()))
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    private val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(Const.Api.BASE_URL)
            .build()

    fun cancelAllRequest() {
        client.dispatcher().cancelAll()
    }

    fun createApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}