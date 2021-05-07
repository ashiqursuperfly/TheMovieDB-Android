package com.gphackathon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gphackathon.R
import com.gphackathon.base.BaseAdapter
import com.gphackathon.base.BaseViewHolder
import com.gphackathon.data.models.MovieData
import com.gphackathon.databinding.RowMovieShortBinding
import com.gphackathon.ui.viewholders.MovieViewHolder

/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class MovieAdapter : BaseAdapter<MovieData>() {

    override fun updateItems(items: ArrayList<MovieData?>) {
        removeAll()
        addItems(items, false)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*, *> {
        val inflater = LayoutInflater.from(parent.context)

        val binding = DataBindingUtil.inflate<RowMovieShortBinding>(
                inflater, R.layout.row_movie_short
                , parent, false
        )
        return MovieViewHolder(binding)
    }

}
