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
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.viewmodel.ListViewModelFav
import com.jitusolution.s160420074.viewmodel.ListViewModelFavMenu


class MenuFavFragment : Fragment() {

    private lateinit var viewModelFavMenu: ListViewModelFavMenu
    private val favMenuListAdapter = FavoriteMenuListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menufav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFavMenu = ViewModelProvider(this).get(ListViewModelFavMenu::class.java)
        viewModelFavMenu.refresh()

        val favoriteMenuView = view.findViewById<RecyclerView>(R.id.favoriteMenuView)
        val progressLoadFavMenu = view.findViewById<ProgressBar>(R.id.progressLoadFavMenu)

        favoriteMenuView.layoutManager = LinearLayoutManager(context)
        favoriteMenuView.adapter = favMenuListAdapter

        viewModelFavMenu.favMenuLD.observe(viewLifecycleOwner, Observer {
            favMenuListAdapter.updateFavMenuList(it)
        })

        viewModelFavMenu.favMenuLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtErrorFavMenu = view.findViewById<TextView>(R.id.txtErrorFavMenu)
            if(it == true) {
                txtErrorFavMenu.visibility = View.VISIBLE
            } else {
                txtErrorFavMenu.visibility = View.GONE
            }
        })

        viewModelFavMenu.favMenuloadingLD.observe(viewLifecycleOwner, Observer {

            if(it == true) {
                favoriteMenuView.visibility = View.GONE
                progressLoadFavMenu.visibility = View.VISIBLE
            } else {
                favoriteMenuView.visibility = View.VISIBLE
                progressLoadFavMenu.visibility = View.GONE
            }
        })


    }


}