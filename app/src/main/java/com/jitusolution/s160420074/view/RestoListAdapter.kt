package com.jitusolution.s160420074.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.util.loadImage
import com.jitusolution.s160420074.model.Resto


class RestoListAdapter (val restoList:ArrayList<Resto>) :RecyclerView.Adapter<RestoListAdapter.RestoViewHolder>()
{

    class RestoViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.home_list_item, parent, false)
        return RestoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestoViewHolder, position: Int) {

        val txtNama = holder.view.findViewById<TextView>(R.id.txtNama)
        val txtJamBukaTutup = holder.view.findViewById<TextView>(R.id.txtJamBukaTutup)
        val txtJarak= holder.view.findViewById<TextView>(R.id.txtJarak)
        val btnDetail= holder.view.findViewById<Button>(R.id.btnDetail)
        val btnMenuResto= holder.view.findViewById<AppCompatImageView>(R.id.btnMenuResto)
        val btnReviewsResto= holder.view.findViewById<AppCompatImageView>(R.id.btnReviewsResto)
        val imageViewResto = holder.view.findViewById<ImageView>(R.id.imageViewResto)
        val progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)




        val resto = restoList[position]
        with(holder.view){
            imageViewResto.loadImage(resto.photourl, progressBar)
            txtNama.text = resto.nama
            txtJamBukaTutup.text = resto.jambukatutup
            txtJarak.text = resto.jarak

            btnDetail.setOnClickListener {

                val action = HomeFragmentDirections.actionRestoDetail(resto.id.toString())
                Navigation.findNavController(it).navigate(action)

            }

            btnMenuResto.setOnClickListener {

                val action = HomeFragmentDirections.actionMenuFragment(resto.id.toString())
                Navigation.findNavController(it).navigate(action)

            }

            btnReviewsResto.setOnClickListener {

                val action = HomeFragmentDirections.actionReviewsFragment(resto.id.toString())
                Navigation.findNavController(it).navigate(action)

            }

        }

    }

    override fun getItemCount(): Int {
        return restoList.size
    }

    fun updateRestoList(newRestoList: ArrayList<Resto>) {
        restoList.clear()
        restoList.addAll(newRestoList)
        notifyDataSetChanged()
    }
}