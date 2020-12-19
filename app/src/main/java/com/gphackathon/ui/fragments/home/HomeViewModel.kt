package com.gphackathon.ui.fragments.home

import androidx.lifecycle.MutableLiveData
import com.gphackathon.base.BaseViewModel
import com.gphackathon.data.Const
import com.gphackathon.data.response.PopularMoviesResponse
import com.gphackathon.util.helper.Toaster
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class HomeViewModel: BaseViewModel() {


    val mPopularMoviesLiveData = MutableLiveData<PopularMoviesResponse>()

    fun getAllPopularMovies(year: String = "2020", sortBy: String = "vote_average.desc") {

        mDisposable.add(
            mApiService.getPopularMovies(
                Const.Api.KEY,
                year,
                sortBy
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Response $it")
                    mPopularMoviesLiveData.postValue(it)

                }, {
                    // val err = handleErrorResponse(it)
                    Timber.d("Request Failed $it")
                    Toaster.showToast(it.message.toString())
                    mPopularMoviesLiveData.postValue(null)
                }
                )
        )

    }

}