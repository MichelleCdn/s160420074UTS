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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.viewmodel.ListViewModelReviews



class ReviewsFragment : Fragment() {

    lateinit var viewModelReviews: ListViewModelReviews
    private val reviewsListAdapter = ReviewsListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_backReviews = view.findViewById<AppCompatImageView>(R.id.btn_backReviews)
        val reviewsView = view.findViewById<RecyclerView>(R.id.reviewsView)
        val txtErrorReviews = view.findViewById<TextView>(R.id.txtErrorReviews)
        val progressLoadReviews = view.findViewById<ProgressBar>(R.id.progressLoadReviews)

        btn_backReviews.setOnClickListener {
            val action = ReviewsFragmentDirections.actionHomeFrag()
            Navigation.findNavController(it).navigate(action)
        }

        if(arguments != null){
            val idResto = RestoDetailFragmentArgs.fromBundle(requireArguments()).restoID
            viewModelReviews = ViewModelProvider(this).get(ListViewModelReviews::class.java)
            viewModelReviews.fetch(idResto)
        }


        reviewsView.layoutManager = LinearLayoutManager(context)
        reviewsView.adapter = reviewsListAdapter

        viewModelReviews.reviewsLD.observe(viewLifecycleOwner, Observer {
            reviewsListAdapter.updateReviewsList(it)
        })

        viewModelReviews.reviewsLoadErrorLD.observe(viewLifecycleOwner, Observer {
//            val txtError = view.findViewById<TextView>(R.id.txtError)
            if(it == true) {
                txtErrorReviews.visibility = View.VISIBLE
            } else {
                txtErrorReviews.visibility = View.GONE
            }
        })

        viewModelReviews.reviewsloadingLD.observe(viewLifecycleOwner, Observer {

            if(it == true) {
                reviewsView.visibility = View.GONE
                progressLoadReviews.visibility = View.VISIBLE
            } else {
                reviewsView.visibility = View.VISIBLE
                progressLoadReviews.visibility = View.GONE
            }
        })



    }


}