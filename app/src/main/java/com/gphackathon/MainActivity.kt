package com.gphackathon

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
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

        val topLevelDestinations = setOf(R.id.homeFragment, R.id.wishlistFragment)
        val appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations)
            .build()

        val nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        mNavController = Navigation.findNavController(this, R.id.fragment_nav_host)
        NavigationUI.setupWithNavController(nav, mNavController)
        NavigationUI.setupActionBarWithNavController(this, mNavController, appBarConfiguration)

        mNavController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.detailsFragment || destination.id == R.id.homeFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }

    }

}