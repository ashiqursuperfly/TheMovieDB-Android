package com.gphackathon.ui.viewholders

import android.view.View
import androidx.core.content.ContextCompat
import com.gphackathon.R
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.Const
import com.gphackathon.data.db.AppDB
import com.gphackathon.data.models.MovieData
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.util.helper.DateUtil
import com.gphackathon.util.helper.load
import java.lang.Exception
import java.text.SimpleDateFormat


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 19/6/20.
*/

class MovieViewHolder(
    private val binding: RowMovieShortBinding
) : BaseViewHolder<MovieData, MovieData.OnClick>(binding.root) {

    val wishlistDb = AppDB.getInstance().wishlistDao()

    override fun onBind() {
        mItem?.let {
            binding.tvName.text = it.title
            try {
                binding.tvDate.text = DateUtil.convertDateFormats(it.release_date, "yyyy-M-dd", Const.DATE_FORMAT)
            }catch (e: Exception) {
                binding.tvDate.text = it.release_date
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