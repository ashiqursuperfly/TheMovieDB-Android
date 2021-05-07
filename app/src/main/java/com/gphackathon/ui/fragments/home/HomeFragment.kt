package com.gphackathon.ui.fragments.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gphackathon.R
import com.gphackathon.base.BaseFragment
import com.gphackathon.data.models.MovieData
import com.gphackathon.data.models.TrendingContent
import com.gphackathon.data.models.TvSeriesData
import com.gphackathon.ui.adapters.MovieAdapter
import com.gphackathon.ui.adapters.TrendingContentAdapter
import com.gphackathon.ui.adapters.TvSeriesAdapter
import com.gphackathon.util.helper.DialogUtil
import com.gphackathon.util.helper.GsonUtil
import com.gphackathon.util.helper.NavigationUtil
import com.gphackathon.util.helper.Toaster
import kotlinx.android.synthetic.main.layout_fragment_home.*


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class HomeFragment: BaseFragment() {

    private lateinit var mMovieAdapter: MovieAdapter
    private lateinit var mSeriesAdapter: TvSeriesAdapter
    private lateinit var mTrendingContentAdapter: TrendingContentAdapter
    private lateinit var mHomeViewModel: HomeViewModel

    override fun getLayoutId(): Int {
        return R.layout.layout_fragment_home
    }

    override fun afterOnViewCreated() {
        mHomeViewModel = requireActivity().let { ViewModelProviders.of(it).get(HomeViewModel::class.java) }
        initMovies()
        initSeries()
        initTrendingContents()

        observeData()
        DialogUtil.showLoader(requireContext())
        mHomeViewModel.getAllPopularMovies()

    }

    private fun observeData() {
        mHomeViewModel.mPopularMoviesLiveData.observe(
            viewLifecycleOwner,
            Observer {
                mHomeViewModel.getAllPopularSeries()
                if (it == null) return@Observer
                mMovieAdapter.updateItems(ArrayList(it.results))

            }
        )
        mHomeViewModel.mPopularSeriesLiveData.observe(
            viewLifecycleOwner,
            Observer {
                mHomeViewModel.getAllTrendingContent()
                if (it == null) return@Observer
                mSeriesAdapter.updateItems(ArrayList(it.results))

            }
        )
        mHomeViewModel.mTrendingContentsLiveData.observe(
            viewLifecycleOwner,
            Observer {
                DialogUtil.hideLoader()
                if (it == null) return@Observer
                mTrendingContentAdapter.updateItems(ArrayList(it.results))
            }
        )
    }

    private fun initMovies() {
        mMovieAdapter = MovieAdapter()
        mMovieAdapter.setCallback(object : MovieData.OnClick {
            override fun onClick(movieData: MovieData) {
                // Toaster.showToast(movieData.overview)
                NavigationUtil.navigate(
                    findNavController(),
                    R.id.homeFragment,
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                        movieJson = GsonUtil.toJson(movieData)
                    )
                )
            }
        })

        rv_movies.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        rv_movies.layoutManager = layoutManager

        rv_movies.adapter = mMovieAdapter

    }

    private fun initSeries() {
        mSeriesAdapter = TvSeriesAdapter()
        mSeriesAdapter.setCallback(object : TvSeriesData.OnClick {
            override fun onClick(seriesData: TvSeriesData) {
                NavigationUtil.navigate(
                    findNavController(),
                    R.id.homeFragment,
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                        seriesJson = GsonUtil.toJson(seriesData)
                    )
                )
            }

        })

        rv_tv_series.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        rv_tv_series.layoutManager = layoutManager

        rv_tv_series.adapter = mSeriesAdapter

    }

    private fun initTrendingContents() {
        mTrendingContentAdapter = TrendingContentAdapter()
        mTrendingContentAdapter.setCallback(object : TrendingContent.OnClick {
            override fun onClick(item: TrendingContent) {
                if (item.isMovie()) {
                    NavigationUtil.navigate(
                        findNavController(),
                        R.id.homeFragment,
                        HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                            movieJson = GsonUtil.toJson(item)
                        )
                    )
                }
                else {
                    NavigationUtil.navigate(
                        findNavController(),
                        R.id.homeFragment,
                        HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                            seriesJson = GsonUtil.toJson(item)
                        )
                    )
                }
            }
        })

        rv_trending.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        rv_trending.layoutManager = layoutManager

        rv_trending.adapter = mTrendingContentAdapter

    }

}