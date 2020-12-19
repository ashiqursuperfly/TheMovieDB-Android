package com.gphackathon.util.api

import android.app.Activity
import com.gphackathon.GpApp
import com.gphackathon.data.Const
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.*
import okhttp3.CacheControl
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
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

    private lateinit var retrofit: Retrofit
    private lateinit var client: OkHttpClient
    private lateinit var cache: Cache

    fun initRetrofit(activity: Activity) {
        setCache(activity)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        client = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(provideCacheInterceptor())
            .addInterceptor(provideOfflineCacheInterceptor())
            .addInterceptor(OkHttpInterceptor.interceptor)
            .addInterceptor(ChuckInterceptor(GpApp.getApplicationContext()))
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(Const.Api.BASE_URL)
            .build()
    }

    fun cancelAllRequest() {
        client.dispatcher().cancelAll()
    }

    fun createApiService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    private fun setCache(activity: Activity): Cache {
        val httpCacheDirectory = File(activity.cacheDir, "offlineCache")

        cache = Cache(httpCacheDirectory, 10 * 1024 * 1024) // 10 MB

        return cache

    }

    private fun provideCacheInterceptor(): Interceptor {
        return Interceptor { chain ->
            var request: Request = chain.request()
            val originalResponse: Response = chain.proceed(request)
            val cacheControl: String? = originalResponse.header("Cache-Control")
            if (cacheControl == null || cacheControl.contains("no-store") || cacheControl.contains("no-cache") ||
                cacheControl.contains("must-revalidate") || cacheControl.contains("max-stale=0")
            ) {
                val cc = CacheControl.Builder()
                    .maxStale(1, TimeUnit.DAYS)
                    .build()
                request = request.newBuilder()
                    .cacheControl(cc)
                    .build()
                chain.proceed(request)
            } else {
                originalResponse
            }
        }
    }

    private fun provideOfflineCacheInterceptor(): Interceptor {
        return Interceptor { chain ->
            try {
                return@Interceptor chain.proceed(chain.request())
            } catch (e: Exception) {
                val cacheControl = CacheControl.Builder()
                    .onlyIfCached()
                    .maxStale(1, TimeUnit.DAYS)
                    .build()
                val offlineRequest = chain.request().newBuilder()
                    .cacheControl(cacheControl)
                    .build()
                return@Interceptor chain.proceed(offlineRequest)
            }
        }
    }

}