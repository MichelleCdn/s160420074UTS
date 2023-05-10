package com.jitusolution.s160420074.view

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.model.Menu
import com.jitusolution.s160420074.util.loadImage
import com.jitusolution.s160420074.model.Resto


class MenuRestoListAdapter (val menuRestoList:ArrayList<Menu>) :RecyclerView.Adapter<MenuRestoListAdapter.MenuRestoViewHolder>()
{

    class MenuRestoViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRestoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.menu_list_item, parent, false)
        return MenuRestoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuRestoViewHolder, position: Int) {

        val txtNamaMakanan = holder.view.findViewById<TextView>(R.id.txtNamaMakanan)
        val txtDescFood = holder.view.findViewById<TextView>(R.id.txtDescFood)
        val txtHarga= holder.view.findViewById<TextView>(R.id.txtHarga)
        val imageViewMenu = holder.view.findViewById<ImageView>(R.id.imageViewMenu)
        val progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)


        val resto = menuRestoList[position]
        with(holder.view){
            imageViewMenu.loadImage(resto.photourl, progressBar)
            txtNamaMakanan.text = resto.nama
            txtHarga.text = "Rp." + resto.harga
            txtDescFood.text = resto.description


        }

    }

    override fun getItemCount(): Int {
        return menuRestoList.size
    }

    fun updateMenuRestoList(newMenuRestoList: ArrayList<Menu>) {
        menuRestoList.clear()
        menuRestoList.addAll(newMenuRestoList)
        notifyDataSetChanged()
    }
}