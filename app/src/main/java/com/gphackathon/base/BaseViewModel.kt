package com.gphackathon.base

import androidx.lifecycle.ViewModel
import com.gphackathon.util.api.ApiClient
import com.gphackathon.util.helper.GsonUtil
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.lang.Exception


/* Created by ashiq.buet16 **/

abstract class BaseViewModel: ViewModel() {

    val mDisposable: CompositeDisposable = CompositeDisposable()

    val mApiService by lazy { ApiClient.createApiService() }

    /*fun handleErrorResponse(error: Throwable): ErrorResponse {
        return try {
            val httpException : HttpException = error as HttpException
            val errorBody: String = httpException.response()?.errorBody()!!.string()
            // use Gson to parse json to your Error handling model class
            val errorResponse: ErrorResponse = GsonUtil.fromJson(errorBody, ErrorResponse::class.java)
            errorResponse
        } catch (e: Exception) {
            return ErrorResponse(detail = error.message?:"unknown error")
        }
    }*/

/*
    val mLoginApiService by lazy { ApiClient.createLoginApiService() }
    val mMenuApiService by lazy { ApiClient.createMenuApiService() }
    val mCommonApiService by lazy { ApiClient.createCommonApiService() }
    val mManifestApiService by lazy { ApiClient.createManifestApiService() }
    val mTransfersOrReceiptsApiService by lazy { ApiClient.createTransfersOrReceiptsApiService() }

*/

    override fun onCleared() {

        mDisposable.dispose()

        super.onCleared()
    }

}