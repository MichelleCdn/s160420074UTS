package com.jitusolution.s160420074.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.model.FavMenu
import com.jitusolution.s160420074.model.FavResto
import com.jitusolution.s160420074.util.loadImage


class FavoriteMenuListAdapter(val favMenuList:ArrayList<FavMenu>) : RecyclerView.Adapter<FavoriteMenuListAdapter.FavMenuViewHolder>()
{
    class FavMenuViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMenuListAdapter.FavMenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fav_menu_list_item, parent, false)
        return FavoriteMenuListAdapter.FavMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteMenuListAdapter.FavMenuViewHolder, position: Int) {
        val txtNamaMakananMenuFav = holder.view.findViewById<TextView>(R.id.txtNamaMakananMenuFav)
        val txtDescFoodMenuFav = holder.view.findViewById<TextView>(R.id.txtDescFoodMenuFav)
        val txtJarakFav= holder.view.findViewById<TextView>(R.id.txtJarakFav)
        val imageViewMenuFav = holder.view.findViewById<ImageView>(R.id.imageViewMenuFav)
        val progressBarMenuFav = holder.view.findViewById<ProgressBar>(R.id.progressBarMenuFav)
        val txtLokasiMenuFav= holder.view.findViewById<TextView>(R.id.txtLokasiMenuFav)

        val favoriteMenu = favMenuList[position]
        with(holder.view){
            txtNamaMakananMenuFav.text = favoriteMenu.nama
            txtDescFoodMenuFav.text = favoriteMenu.description
            txtLokasiMenuFav.text = favoriteMenu.lokasi


            imageViewMenuFav.loadImage(favoriteMenu.photourl, progressBarMenuFav)


        }
    }

    override fun getItemCount(): Int {
        return favMenuList.size
    }


    fun updateFavMenuList(newFavMenuList: ArrayList<FavMenu>) {
        favMenuList.clear()
        favMenuList.addAll(newFavMenuList)
        notifyDataSetChanged()
    }
}