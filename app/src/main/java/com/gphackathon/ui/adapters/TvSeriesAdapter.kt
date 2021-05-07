package com.gphackathon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gphackathon.R
import com.gphackathon.base.BaseAdapter
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.models.TvSeriesData
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.databinding.RowSeriesShortBinding
import com.gphackathon.ui.viewholders.MovieViewHolder
import com.gphackathon.ui.viewholders.TvSeriesViewHolder


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class TvSeriesAdapter : BaseAdapter<TvSeriesData>() {

    override fun updateItems(items: ArrayList<TvSeriesData?>) {
        removeAll()
        addItems(items, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<RowSeriesShortBinding>(
            inflater, R.layout.row_series_short
            , parent, false
        )
        return TvSeriesViewHolder(binding)
    }

}
