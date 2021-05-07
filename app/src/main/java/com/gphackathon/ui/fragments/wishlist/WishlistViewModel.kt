package com.gphackathon.ui.fragments.wishlist

import com.gphackathon.base.BaseViewModel
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.local.WishlistEntity


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class WishlistViewModel: BaseViewModel() {
    val wishlistDb = AppDB.getInstance().wishlistDao()

    fun getAllWishlistItems(): ArrayList<WishlistEntity?> {
        return ArrayList(wishlistDb.getAll())
    }

}