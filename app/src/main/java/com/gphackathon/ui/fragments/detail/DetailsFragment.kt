package com.gphackathon.ui.fragments.detail

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gphackathon.R
import com.gphackathon.base.BaseFragment
import com.gphackathon.data.Const
import com.gphackathon.data.models.MovieData
import com.gphackathon.data.models.TvSeriesData
import com.gphackathon.data.response.detail.movie.MovieDetailResponse
import com.gphackathon.data.response.detail.series.SeriesDetailResponse
import com.gphackathon.util.helper.*
import kotlinx.android.synthetic.main.layout_fragment_detail.*
import java.lang.Exception


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class DetailsFragment: BaseFragment() {

    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var mDetailsViewModel: DetailViewModel

    override fun getLayoutId(): Int {
        return R.layout.layout_fragment_detail
    }

    override fun afterOnViewCreated() {
        mDetailsViewModel = requireActivity().let { ViewModelProviders.of(it).get(DetailViewModel::class.java) }
        observeData()
        
        when {
            args.movieJson != null -> {
                DialogUtil.showLoader(requireContext())
                val movie = GsonUtil.fromJson(args.movieJson.toString(), MovieData::class.java)
                mDetailsViewModel.getMovieDetails(movie.id)
            }
            args.seriesJson != null -> {
                DialogUtil.showLoader(requireContext())
                val series = GsonUtil.fromJson(args.seriesJson.toString(), TvSeriesData::class.java)
                mDetailsViewModel.getSeriesDetails(series.id)
            }
            else -> {
                Toaster.showToast("Error: Invalid Content !")
                NavigationUtil.popBackStack(findNavController(), requireActivity())
            }
        }
    }

    private fun updateUi(movie: MovieDetailResponse) {
        tv_name.text = movie.title
        try {
            tv_date.text = DateUtil.convertDateFormats(movie.release_date, "yyyy-M-dd", Const.DATE_FORMAT)
        }catch (e: Exception) {
            tv_date.text = movie.release_date
        }
        if (movie.overview.isNotBlank()) {
            tv_overview.text = movie.overview
            tv_overview.visibility = View.VISIBLE
        }else {
            tv_overview.visibility = View.GONE
        }
        if (movie.tagline.isNotBlank()) {
            tv_tagline.text = movie.tagline
            tv_tagline.visibility = View.VISIBLE
        }else {
            tv_tagline.visibility = View.GONE
        }
        tv_votes.text = movie.vote_count.toString()
        image.load(Const.Api.BASE_POSTER_IMAGE + movie.poster_path)
    }
    private fun updateUi(series: SeriesDetailResponse) {
        tv_name.text = series.name
        try {
            tv_date.text = DateUtil.convertDateFormats(series.first_air_date, "yyyy-M-dd", Const.DATE_FORMAT)
        }catch (e: Exception) {
            tv_date.text = series.first_air_date
        }
        if (series.overview.isNotBlank()) {
            tv_overview.text = series.overview
            tv_overview.visibility = View.VISIBLE
        }else {
            tv_overview.visibility = View.GONE
        }
        if (series.tagline.isNotBlank()) {
            tv_tagline.text = series.tagline
            tv_tagline.visibility = View.VISIBLE
        }else {
            tv_tagline.visibility = View.GONE
        }
        tv_votes.text = series.vote_count.toString()
        image.load(Const.Api.BASE_POSTER_IMAGE + series.poster_path)
    }

    private fun observeData() {
        mDetailsViewModel.mMovieDetailLiveData.observe(
            viewLifecycleOwner,
            Observer {
                DialogUtil.hideLoader()
                if (it == null) return@Observer
                updateUi(it)
            }
        )
        mDetailsViewModel.mSeriesDetailLiveData.observe(
            viewLifecycleOwner,
            Observer {
                DialogUtil.hideLoader()
                if (it == null) return@Observer
                updateUi(it)
            }
        )
    }
}