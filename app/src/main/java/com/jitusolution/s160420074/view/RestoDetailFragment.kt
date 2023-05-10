package com.jitusolution.s160420074.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.util.loadImage
import com.jitusolution.s160420074.viewmodel.DetailViewModel


class RestoDetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resto_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val imageResto = view.findViewById<ImageView>(R.id.imageResto)
        val textRestoName = view.findViewById<TextView>(R.id.textRestoName)
        val textViewAlamat = view.findViewById<TextView>(R.id.textViewAlamat)
        val textViewTypeFood = view.findViewById<TextView>(R.id.textViewTypeFood)
        val textViewOpenHour = view.findViewById<TextView>(R.id.textViewOpenHour)
        val textViewDescResto = view.findViewById<TextView>(R.id.textViewDescResto)
        val progressBarRestoDetail = view.findViewById<ProgressBar>(R.id.progressBarRestoDetail)
        val btn_back = view.findViewById<AppCompatImageView>(R.id.btn_back)

        if(arguments != null){
            val idResto = RestoDetailFragmentArgs.fromBundle(requireArguments()).restoID
            detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
            detailViewModel.fetch(idResto)
        }

        detailViewModel.restoLD.observe(viewLifecycleOwner){
                restoDetail ->
            imageResto.loadImage(restoDetail.photourl.toString(),progressBarRestoDetail)
            textRestoName.setText(restoDetail.nama.toString())
            textViewAlamat.setText(restoDetail.alamat.toString())
            textViewTypeFood.setText(restoDetail.typefood.toString())
            textViewOpenHour.setText(restoDetail.jambukatutup.toString())
            textViewDescResto.setText(restoDetail.description.toString())


        }


        btn_back.setOnClickListener {
            val action = RestoDetailFragmentDirections.actionHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }


}