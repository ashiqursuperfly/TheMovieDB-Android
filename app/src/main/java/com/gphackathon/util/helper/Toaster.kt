package com.gphackathon.util.helper

import android.content.Context
import android.widget.Toast
import com.gphackathon.base.BaseApplication
import java.lang.Exception


/* Created by ashiq.buet16 **/

object Toaster {

    fun showToast(message: String, context: Context = BaseApplication.getApplicationContext()) {
        show(context, message, Toast.LENGTH_SHORT)
    }

    fun showLongToast(message: String, context: Context = BaseApplication.getApplicationContext()) {
        show(context, message, Toast.LENGTH_LONG)
    }

    private fun show(context: Context, message: String, length: Int) {
        try {
            Toast.makeText(context, message, length).show()
        } catch (e: Exception) {}
    }

}