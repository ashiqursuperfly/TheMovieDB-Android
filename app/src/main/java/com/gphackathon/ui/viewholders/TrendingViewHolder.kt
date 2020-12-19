package com.gphackathon.ui.viewholders

import android.view.View
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.Const
import com.gphackathon.data.models.TrendingContent
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.databinding.RowTrendingContentBinding
import com.gphackathon.util.helper.DateUtil
import com.gphackathon.util.helper.load
import java.lang.Exception


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class TrendingViewHolder(
    private val binding: RowTrendingContentBinding
) : BaseViewHolder<TrendingContent, TrendingContent.OnClick>(binding.root) {

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