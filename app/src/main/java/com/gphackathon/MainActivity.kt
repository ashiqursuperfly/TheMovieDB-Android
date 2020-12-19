package com.gphackathon

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.gphackathon.base.BaseActivity


class MainActivity : BaseActivity() {

    private lateinit var mNavController: NavController

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getToolbarId(): Int {
        return NO_TOOLBAR
    }

    override fun afterOnCreate() {
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        mNavController = Navigation.findNavController(this, R.id.fragment_nav_host)
        NavigationUI.setupWithNavController(nav, mNavController)

        mNavController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailsFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
    }

}