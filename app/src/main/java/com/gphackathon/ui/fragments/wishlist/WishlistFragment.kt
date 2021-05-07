package com.gphackathon.ui.fragments.wishlist

import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gphackathon.R
import com.gphackathon.base.BaseFragment
import com.gphackathon.data.models.TrendingContent
import com.gphackathon.data.models.local.WishlistEntity
import com.gphackathon.ui.adapters.WishlistAdapter
import com.gphackathon.ui.fragments.home.HomeFragmentDirections
import com.gphackathon.ui.fragments.home.HomeViewModel
import com.gphackathon.util.helper.GsonUtil
import com.gphackathon.util.helper.NavigationUtil
import kotlinx.android.synthetic.main.layout_fragment_home.*
import kotlinx.android.synthetic.main.layout_fragment_wishlist.*


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class WishlistFragment: BaseFragment() {

    private lateinit var mWishlistAdapter: WishlistAdapter
    private lateinit var mWishlistViewModel: WishlistViewModel

    override fun getLayoutId(): Int {
        return R.layout.layout_fragment_wishlist
    }

    override fun afterOnViewCreated() {
        initWishlist()
    }

    private fun initWishlist() {
        mWishlistViewModel = requireActivity().let { ViewModelProviders.of(it).get(WishlistViewModel::class.java) }
        mWishlistAdapter = WishlistAdapter()
        mWishlistAdapter.setCallback(object : WishlistEntity.OnClick {
            override fun onDelete(item: WishlistEntity) {
                mWishlistAdapter.updateItems(mWishlistViewModel.getAllWishlistItems())
            }
        })

        rv_wishlist.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        rv_wishlist.layoutManager = layoutManager

        rv_wishlist.adapter = mWishlistAdapter

        mWishlistAdapter.updateItems(mWishlistViewModel.getAllWishlistItems())

    }
}