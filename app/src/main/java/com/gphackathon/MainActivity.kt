package com.gphackathon

import com.gphackathon.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getToolbarId(): Int {
        return NO_TOOLBAR
    }

    override fun afterOnCreate() {

    }

}