package com.jitusolution.s160420074.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.viewmodel.ListViewModel


class HomeFragment : Fragment() {

    private lateinit var viewModel:ListViewModel
    private val restoListAdapter = RestoListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        val homeView = view.findViewById<RecyclerView>(R.id.homeView)
        val progressLoad = view.findViewById<ProgressBar>(R.id.progressLoad)
        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtError = view.findViewById<TextView>(R.id.txtError)

        homeView.layoutManager = LinearLayoutManager(context)
        homeView.adapter = restoListAdapter

        viewModel.restoLD.observe(viewLifecycleOwner, Observer {
            restoListAdapter.updateRestoList(it)
        })

        viewModel.restoLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtError = view.findViewById<TextView>(R.id.txtError)
            if(it == true) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {

            if(it == true) {
                homeView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else {
                homeView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })

        refreshLayout.setOnRefreshListener {
            homeView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }


    }




}