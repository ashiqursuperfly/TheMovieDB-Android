package com.gphackathon.util.helper

import android.net.Uri
import android.widget.ImageView
import com.gphackathon.R

import com.gphackathon.util.helper.GlideUtil

fun ImageView.load(res: Int) {
    GlideUtil.load(res, R.drawable.ic_broken_img, this)
}

fun ImageView.load(url: String?) {
    GlideUtil.load(url, R.drawable.ic_broken_img, this)
}

fun ImageView.loadProfile(url: String?) {
    GlideUtil.load(url, R.drawable.ic_broken_img, this)
}

fun ImageView.load(url: Uri?) {
    GlideUtil.load(url, R.drawable.ic_broken_img, this)
}
