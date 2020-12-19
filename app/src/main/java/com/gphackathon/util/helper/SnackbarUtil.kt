package com.gphackathon.util.helper

import android.os.Build
import android.view.View
import android.widget.Toast

import com.gphackathon.util.helper.AndroidUtil.getColorFromAttr
import com.google.android.material.snackbar.Snackbar
import com.gphackathon.R

object SnackbarUtil {

    fun showLongSnackBar(
        view: View,
        message: String,
        attrRes: Int = R.attr.colorPrimary
    ) {
        val color = view.context.getColorFromAttr(attrRes)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            snackbar.view.setBackgroundColor(color)
            snackbar.show()
        }
        else
            Toast.makeText(view.context, message, Toast.LENGTH_LONG).show()
    }

    fun showShortSnackBar(
        view: View,
        message: String,
        attrRes: Int = R.attr.colorPrimary
    ) {
        val color = view.context.getColorFromAttr(attrRes)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            snackbar.view.setBackgroundColor(color)
            snackbar.show()
        }
        else
            Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
    }
}