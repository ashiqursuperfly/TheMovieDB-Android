package com.gphackathon.ui.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import com.gphackathon.R
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.Const
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.MovieData
import com.gphackathon.data.models.TvSeriesData
import com.gphackathon.data.models.local.WishlistEntity
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.databinding.RowSeriesShortBinding
import com.gphackathon.util.helper.DateUtil
import com.gphackathon.util.helper.load
import java.lang.Exception


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class TvSeriesViewHolder(
    private val binding: RowSeriesShortBinding
) : BaseViewHolder<TvSeriesData, TvSeriesData.OnClick>(binding.root) {

    val wishlistDb = AppDB.getInstance().wishlistDao()

    override fun onBind() {
        mItem?.let {
            binding.tvName.text = it.name
            try {
                binding.tvDate.text = DateUtil.convertDateFormats(it.first_air_date, "yyyy-M-dd", Const.DATE_FORMAT)
            }catch (e: Exception) {
                binding.tvDate.text = it.first_air_date
            }

            binding.tvVotes.text = it.vote_count.toString()
            binding.image.load(it.getPosterImageUrl())

            if (wishlistDb.get(it.id) != null) {
                binding.btnAddToWishlist.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_wishlist_fill))
            }
            else {
                binding.btnAddToWishlist.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_wishlist))
            }
            setClickListener(binding.container)
        }
    }

    override fun onClick(v: View?) {
        super.onClick(v)

        if (v == binding.container) {
            mCallback?.onClick(mItem!!)
        }
    }
}