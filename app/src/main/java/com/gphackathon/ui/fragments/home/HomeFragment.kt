package com.gphackathon.ui.fragments.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gphackathon.R
import com.gphackathon.base.BaseFragment
import com.gphackathon.data.models.MovieData
import com.gphackathon.ui.adapters.MovieAdapter
import com.gphackathon.util.helper.Toaster
import kotlinx.android.synthetic.main.layout_fragment_home.*


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/19/20.
*/

class HomeFragment: BaseFragment() {

    private lateinit var mMovieAdapter: MovieAdapter
    private lateinit var mHomeViewModel: HomeViewModel

    override fun getLayoutId(): Int {
        return R.layout.layout_fragment_home
    }

    override fun afterOnViewCreated() {
        mHomeViewModel = requireActivity().let { ViewModelProviders.of(it).get(HomeViewModel::class.java) }
        initRecyclerView()

        observeData()
        mHomeViewModel.getAllPopularMovies()
    }

    private fun observeData() {
        mHomeViewModel.mPopularMoviesLiveData.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) return@Observer
                mMovieAdapter.updateItems(ArrayList(it.results))

            }
        )
    }

    private fun initRecyclerView() {
        mMovieAdapter = MovieAdapter()
        mMovieAdapter.setCallback(object : MovieData.OnClick {
            override fun onClick(movieData: MovieData) {
                Toaster.showToast(movieData.overview)
            }
        })

        rv_movies.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(context, GridLayoutManager.HORIZONTAL, false)

        rv_movies.layoutManager = layoutManager

        rv_movies.adapter = mMovieAdapter

    }
}