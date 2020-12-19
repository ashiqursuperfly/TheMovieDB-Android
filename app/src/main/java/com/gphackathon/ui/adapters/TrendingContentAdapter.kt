package com.gphackathon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gphackathon.R
import com.gphackathon.base.BaseAdapter
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.models.MovieData
import com.gphackathon.data.models.TrendingContent
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.databinding.RowTrendingContentBinding
import com.gphackathon.ui.viewholders.MovieViewHolder
import com.gphackathon.ui.viewholders.TrendingViewHolder


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class TrendingContentAdapter : BaseAdapter<TrendingContent>() {

    override fun updateItems(items: ArrayList<TrendingContent?>) {
        removeAll()
        addItems(items, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<RowTrendingContentBinding>(
            inflater, R.layout.row_trending_content
            , parent, false
        )
        return TrendingViewHolder(binding)
    }

}