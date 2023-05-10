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
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.viewmodel.ListViewModelFav




class FavoriteFragment : Fragment() {

    private lateinit var viewModelFav: ListViewModelFav
    private val favListAdapter = FavoriteListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFav = ViewModelProvider(this).get(ListViewModelFav::class.java)
        viewModelFav.refresh()

        val favoriteView = view.findViewById<RecyclerView>(R.id.favoriteView)
        val progressLoadFav = view.findViewById<ProgressBar>(R.id.progressLoadFav)
        val txtErrorFav = view.findViewById<TextView>(R.id.txtErrorFav)
        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)

        favoriteView.layoutManager = LinearLayoutManager(context)
        favoriteView.adapter = favListAdapter

        viewModelFav.favRestoLD.observe(viewLifecycleOwner, Observer {
            favListAdapter.updateFavList(it)
        })

        viewModelFav.favRestoLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtErrorFav = view.findViewById<TextView>(R.id.txtErrorFav)
            if(it == true) {
                txtErrorFav.visibility = View.VISIBLE
            } else {
                txtErrorFav.visibility = View.GONE
            }
        })

        viewModelFav.favloadingLD.observe(viewLifecycleOwner, Observer {

            if(it == true) {
                favoriteView.visibility = View.GONE
                progressLoadFav.visibility = View.VISIBLE
            } else {
                favoriteView.visibility = View.VISIBLE
                progressLoadFav.visibility = View.GONE
            }
        })

        refreshLayout.setOnRefreshListener {
            favoriteView.visibility = View.GONE
            txtErrorFav.visibility = View.GONE
            progressLoadFav.visibility = View.VISIBLE
            viewModelFav.refresh()
            refreshLayout.isRefreshing = false
        }
    }


}