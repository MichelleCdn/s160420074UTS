package com.jitusolution.s160420074.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.util.loadImage
import com.jitusolution.s160420074.viewmodel.DetailViewModel
import com.jitusolution.s160420074.viewmodel.ListViewModel
import com.jitusolution.s160420074.viewmodel.ListViewModelRestoMenu


class MenuFragment : Fragment() {

    lateinit var viewModelRestoMenu: ListViewModelRestoMenu
    private val menuRestoListAdapter = MenuRestoListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuView = view.findViewById<RecyclerView>(R.id.menuView)
        val progressLoadMenu = view.findViewById<ProgressBar>(R.id.progressLoadMenu)
        val btn_backMenu = view.findViewById<AppCompatImageView>(R.id.btn_backMenu)


        btn_backMenu.setOnClickListener {
            val action = MenuFragmentDirections.actionHomeFragm()
            Navigation.findNavController(it).navigate(action)
        }

        if(arguments != null){
            val idResto = RestoDetailFragmentArgs.fromBundle(requireArguments()).restoID
            viewModelRestoMenu = ViewModelProvider(this).get(ListViewModelRestoMenu::class.java)
            viewModelRestoMenu.fetch(idResto)
        }



        menuView.layoutManager = LinearLayoutManager(context)
        menuView.adapter = menuRestoListAdapter

        viewModelRestoMenu.restoMenuLD.observe(viewLifecycleOwner, Observer {
            menuRestoListAdapter.updateMenuRestoList(it)
        })

        viewModelRestoMenu.restoMenuLoadErrorLD.observe(viewLifecycleOwner, Observer {
            val txtErrorMenu = view.findViewById<TextView>(R.id.txtErrorMenu)

            if(it == true) {
                txtErrorMenu.visibility = View.VISIBLE
            } else {
                txtErrorMenu.visibility = View.GONE
            }
        })

        viewModelRestoMenu.menuloadingLD.observe(viewLifecycleOwner, Observer {



            if(it == true) {
                menuView.visibility = View.GONE
                progressLoadMenu.visibility = View.VISIBLE
            } else {
                menuView.visibility = View.VISIBLE
                progressLoadMenu.visibility = View.GONE
            }
        })


    }

}