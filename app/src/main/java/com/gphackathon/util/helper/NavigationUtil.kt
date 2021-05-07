package com.gphackathon.util.helper

import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import java.lang.IllegalStateException


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/6/20.
*/

object NavigationUtil {

    fun navigate(
            navController: NavController,
            currentDestinationResId: Int,
            actionProfileStep2ToPickEducation: NavDirections
    ) {

        if (navController.currentDestination?.id == currentDestinationResId) {
            navController.navigate(
                    actionProfileStep2ToPickEducation
            )
        } else {
            Toaster.showToast("Could not navigate to next page!!")
        }

    }

    fun popBackStack(navController: NavController, requireActivity: FragmentActivity) {
        try{
            navController.popBackStack()
        }catch (ise: IllegalStateException) {
            requireActivity.onBackPressed()
        }

    }

}