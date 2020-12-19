package com.gphackathon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gphackathon.R
import com.gphackathon.base.BaseAdapter
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.models.local.WishlistEntity
import com.gphackathon.databinding.RowWishlistBinding
import com.gphackathon.ui.viewholders.WishlistViewHolder


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class WishlistAdapter : BaseAdapter<WishlistEntity>() {

    override fun updateItems(items: ArrayList<WishlistEntity?>) {
        removeAll()
        addItems(items, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<RowWishlistBinding>(
            inflater, R.layout.row_wishlist
            , parent, false
        )
        return WishlistViewHolder(binding)
    }

}
