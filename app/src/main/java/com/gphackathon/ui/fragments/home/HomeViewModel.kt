package com.gphackathon.ui.fragments.home

import androidx.lifecycle.MutableLiveData
import com.gphackathon.BuildConfig
import com.gphackathon.base.BaseViewModel
import com.gphackathon.data.Const
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.local.WishlistEntity
import com.gphackathon.data.response.PopularMoviesResponse
import com.gphackathon.data.response.PopularTVSeriesResponse
import com.gphackathon.data.response.TrendingContentResponse
import com.gphackathon.util.helper.Toaster
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class HomeViewModel: BaseViewModel() {

    val wishlistDb = AppDB.getInstance().wishlistDao()

    val mPopularMoviesLiveData = MutableLiveData<PopularMoviesResponse>()
    val mPopularSeriesLiveData = MutableLiveData<PopularTVSeriesResponse>()
    val mTrendingContentsLiveData = MutableLiveData<TrendingContentResponse>()


    fun getAllPopularMovies(year: String = "2020", sortBy: String = "vote_average.desc") {

        mDisposable.add(
            mApiService.getPopularMovies(
                BuildConfig.API_KEY,
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

    fun getAllPopularSeries(year: String = "2020", sortBy: String = "vote_average.desc") {

        mDisposable.add(
            mApiService.getPopularTvSeries(
                BuildConfig.API_KEY,
                year,
                sortBy
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Response $it")
                    mPopularSeriesLiveData.postValue(it)

                }, {
                    // val err = handleErrorResponse(it)
                    Timber.d("Request Failed $it")
                    Toaster.showToast(it.message.toString())
                    mPopularSeriesLiveData.postValue(null)
                }
                )
        )

    }

    fun getAllTrendingContent() {

        mDisposable.add(
            mApiService.getTrendingContents(
                BuildConfig.API_KEY
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Response $it")
                    mTrendingContentsLiveData.postValue(it)

                }, {
                    // val err = handleErrorResponse(it)
                    Timber.d("Request Failed $it")
                    Toaster.showToast(it.message.toString())
                    mTrendingContentsLiveData.postValue(null)
                }
                )
        )

    }

    fun wishlistAddOrRemove(
        id: Int,
        name: String,
        date: String,
        poster_path: String,
        type: String
    ) {
        if (wishlistDb.get(id) == null) {
            wishlistDb.insert(WishlistEntity(
                id, name, poster_path, date, type
            ))
        }
        else {
            wishlistDb.delete(WishlistEntity(
                id, name, poster_path, date, type
            ))
        }
    }

}