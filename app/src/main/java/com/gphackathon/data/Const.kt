package com.gphackathon.data
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

    const val DATE_FORMAT = "dd MMM YYYY"

    const val UNLABELLED_DATA_ID = -1

    object RequestCode {
        const val CAMERA_PERMISSION = 1031
    }

    object Api {

        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_POSTER_IMAGE = "https://image.tmdb.org/t/p/w780"
        const val BASE_BACKDROP_IMAGE = "https://image.tmdb.org/t/p/w780"

        const val KEY = "1a97f3b8d5deee1d649c0025f3acf75c"

        const val SUCCESS = "success"

        object EndPoints {
            const val GET_POPULAR_MOVIES = "discover/movie"
            const val GET_POPULAR_TV_SERIES = "discover/tv"
            const val GET_TRENDING_CONTENT = "trending/all/week"
            const val GET_MOVIE_DETAIL = "https://api.themoviedb.org/3/movie/{${Params.ID}}"
            const val GET_SERIES_DETAIL = "https://api.themoviedb.org/3/tv/{${Params.ID}}"
        }

        object Params {
            const val API_KEY = "api_key"
            const val RELEASE_YEAR = "primary_release_year"
            const val SORT_BY = "sort_by"
            const val ID = "id"
        }
    }

}