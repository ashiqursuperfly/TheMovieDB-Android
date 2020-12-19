package com.gphackathon.ui.fragments.detail

import androidx.lifecycle.MutableLiveData
import com.gphackathon.base.BaseViewModel
import com.gphackathon.data.Const
import com.gphackathon.data.response.detail.movie.MovieDetailResponse
import com.gphackathon.data.response.detail.series.SeriesDetailResponse
import com.gphackathon.util.helper.Toaster
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class DetailViewModel: BaseViewModel() {

    val mMovieDetailLiveData = MutableLiveData<MovieDetailResponse>()
    val mSeriesDetailLiveData = MutableLiveData<SeriesDetailResponse>()

    fun getSeriesDetails(id: Int) {

        mDisposable.add(
            mApiService.getSeriesDetail(
                id = id.toString(),
                apiKey = Const.Api.KEY
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Response $it")
                    mSeriesDetailLiveData.postValue(it)

                }, {
                    // val err = handleErrorResponse(it)
                    Timber.d("Request Failed $it")
                    Toaster.showToast(it.message.toString())
                    mSeriesDetailLiveData.postValue(null)
                }
                )
        )

    }

    fun getMovieDetails(id: Int) {

        mDisposable.add(
            mApiService.getMovieDetail(
                id = id.toString(),
                apiKey = Const.Api.KEY
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Response $it")
                    mMovieDetailLiveData.postValue(it)

                }, {
                    // val err = handleErrorResponse(it)
                    Timber.d("Request Failed $it")
                    Toaster.showToast(it.message.toString())
                    mMovieDetailLiveData.postValue(null)
                }
                )
        )

    }

}