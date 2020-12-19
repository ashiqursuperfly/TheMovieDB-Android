package com.gphackathon.data

import com.gphackathon.BuildConfig


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/6/20.
*/

object Const {

    object DB {
        const val VERSION = 1
        object TABLE_NAME {
            const val WISHLIST = "local_wishlist"
        }
    }

    const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"

    const val UNLABELLED_DATA_ID = -1

    object RequestCode {
        const val CAMERA_PERMISSION = 1031
    }

    object Api {

        val BASE_URL = "https://api.themoviedb.org/3/"

        const val SUCCESS = "success"

        object EndPoints {
            const val GET_POPULAR_MOVIES = "discover/movie"
            const val GET_POPULAR_TV_SERIES = "discover/tv"
            const val GET_TRENDING_CONTENT = "trending/all/week"
        }

        object Params {
            const val API_KEY = "api_key"
            const val RELEASE_YEAR = "primary_release_year"
            const val SORT_BY = "sort_by"
        }
    }

}