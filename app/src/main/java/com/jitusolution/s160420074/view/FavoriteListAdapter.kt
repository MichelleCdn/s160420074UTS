package com.jitusolution.s160420074.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.model.FavResto
import com.jitusolution.s160420074.util.loadImage


class FavoriteListAdapter(val favList:ArrayList<FavResto>) : RecyclerView.Adapter<FavoriteListAdapter.FavViewHolder>()
{
    class FavViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteListAdapter.FavViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fav_list_item, parent, false)
        return FavoriteListAdapter.FavViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteListAdapter.FavViewHolder, position: Int) {
        val txtNamaFav = holder.view.findViewById<TextView>(R.id.txtNamaFav)
        val txtJamBukaTutupFav = holder.view.findViewById<TextView>(R.id.txtJamBukaTutupFav)
        val txtJarakFav= holder.view.findViewById<TextView>(R.id.txtJarakFav)
        val imageViewFav = holder.view.findViewById<ImageView>(R.id.imageViewFav)
        val progressBarFav = holder.view.findViewById<ProgressBar>(R.id.progressBarFav)
        val btnFavDetail = holder.view.findViewById<Button>(R.id.btnDetailFavDetail)

        val favorite = favList[position]
        with(holder.view){
            txtNamaFav.text = favorite.nama
            txtJamBukaTutupFav.text = favorite.jambukatutup
            txtJarakFav.text = favorite.jarak

            btnFavDetail.setOnClickListener {

                val action = FavoriteFragmentDirections.actionFavDetailFrag(favorite.id.toString())
                Navigation.findNavController(it).navigate(action)

            }

            imageViewFav.loadImage(favorite.photourl, progressBarFav)


        }
    }

    override fun getItemCount(): Int {
        return favList.size
    }


    fun updateFavList(newFavList: ArrayList<FavResto>) {
        favList.clear()
        favList.addAll(newFavList)
        notifyDataSetChanged()
    }
}