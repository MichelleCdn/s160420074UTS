package com.jitusolution.s160420074.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jitusolution.s160420074.R
import com.jitusolution.s160420074.model.Reviews


class ReviewsListAdapter (val reviewsList:ArrayList<Reviews>) :RecyclerView.Adapter<ReviewsListAdapter.ReviewsViewHolder>()
{

    class ReviewsViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.reviews_list_item, parent, false)
        return ReviewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {

        val txtReviewer = holder.view.findViewById<TextView>(R.id.txtReviewer)
        val txtReviews = holder.view.findViewById<TextView>(R.id.txtReviews)
        val txtRate = holder.view.findViewById<TextView>(R.id.txtRate)
        val txtTanggal = holder.view.findViewById<TextView>(R.id.txtTanggal)


        val reviews = reviewsList[position]
        with(holder.view){

            txtReviewer.text = reviews.nama
            txtReviews.text = reviews.comment
            txtRate.text = reviews.bintang
            txtTanggal.text = reviews.tanggal

        }


    }

    override fun getItemCount(): Int {
        return reviewsList.size
    }

    fun updateReviewsList(newReviewsList: ArrayList<Reviews>) {
        reviewsList.clear()
        reviewsList.addAll(newReviewsList)
        notifyDataSetChanged()
    }
}