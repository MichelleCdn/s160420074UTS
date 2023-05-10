package com.jitusolution.s160420074.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.util.loadImage
import com.jitusolution.s160420074.viewmodel.DetailViewModelFav


class FavDetailFragment : Fragment() {

    private lateinit var detailViewModelFav: DetailViewModelFav

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fav_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val idResto = FavDetailFragmentArgs.fromBundle(requireArguments()).restoID
            detailViewModelFav = ViewModelProvider(this).get(DetailViewModelFav::class.java)
            detailViewModelFav.fetch(idResto)
        }

        val imageFavResto = view.findViewById<ImageView>(R.id.imageFavResto)
        val textFavRestoName = view.findViewById<TextView>(R.id.textFavRestoName)
        val textViewFavAlamat = view.findViewById<TextView>(R.id.textViewFavAlamat)
        val textViewFavTypeFood = view.findViewById<TextView>(R.id.textViewFavTypeFood)
        val textViewFavOpenHour = view.findViewById<TextView>(R.id.textViewFavOpenHour)
        val textViewFavDescResto = view.findViewById<TextView>(R.id.textViewFavDescResto)
        val progressBarFavRestoDetail = view.findViewById<ProgressBar>(R.id.progressBarFavRestoDetail)
        val btn_backFav = view.findViewById<AppCompatImageView>(R.id.btn_backFav)

        detailViewModelFav.favrestoLD.observe(viewLifecycleOwner){
                favrestoDetail ->
            imageFavResto.loadImage(favrestoDetail.photourl.toString(),progressBarFavRestoDetail)
            textFavRestoName.setText(favrestoDetail.nama.toString())
            textViewFavAlamat.setText(favrestoDetail.alamat.toString())
            textViewFavTypeFood.setText(favrestoDetail.typefood.toString())
            textViewFavOpenHour.setText(favrestoDetail.jambukatutup.toString())
            textViewFavDescResto.setText(favrestoDetail.description.toString())


        }


        btn_backFav.setOnClickListener {
            val action = FavDetailFragmentDirections.actionFavFrag()
            Navigation.findNavController(it).navigate(action)
        }

    }
}