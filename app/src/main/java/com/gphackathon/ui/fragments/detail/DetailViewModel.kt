package com.gphackathon.ui.fragments.detail

import androidx.lifecycle.MutableLiveData
import com.gphackathon.base.BaseViewModel
import com.gphackathon.data.Const
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.local.WishlistEntity
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

    val wishlistDb = AppDB.getInstance().wishlistDao()

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

    fun isInWishlist(id: Int): Boolean {
        return wishlistDb.get(id) != null
    }

    fun wishlistAddOrRemove(
        id: Int,
        name: String,
        date: String,
        poster_path: String,
        type: String
    ): Boolean {
        if (wishlistDb.get(id) == null) {
            wishlistDb.insert(WishlistEntity(
                id, name, poster_path, date, type
            ))
            Timber.d("Adding to DB: ${name}")
            return true
        }
        else {
            wishlistDb.delete(WishlistEntity(
                id, name, poster_path, date, type
            ))
            Timber.d("Removing from DB: ${name}")
            return false
        }
    }

}