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

        val BASE_URL = "https://api.themoviedb.org/"

        const val SUCCESS = "success"

        object EndPoints {
            const val GET_CROPS = "crop"
            const val GET_CROP_PROBLEMS = "issue"
            const val GET_IMAGE_DATA_CATEGORY = "image-category"
        }
    }

}