package com.jitusolution.s160420074.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jitusolution.s160420074.model.Menu
import com.jitusolution.s160420074.model.Resto
import com.jitusolution.s160420074.model.Reviews


class ListViewModelReviews(application: Application): AndroidViewModel(application) {
    val reviewsLD = MutableLiveData<ArrayList<Reviews>>()
    val reviewsLoadErrorLD = MutableLiveData<Boolean>()
    val reviewsloadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null



    fun fetch(id: String) {

        reviewsloadingLD.value = true
        reviewsLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.2.89/ubayakuliner/resto/reviews.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {

                val sType = object : TypeToken<ArrayList<Reviews>>() { }.type
                val result = Gson().fromJson<ArrayList<Reviews>>(it, sType)
                reviewsLD.value = result
                reviewsloadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
                reviewsLoadErrorLD.value = false
                reviewsloadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }


    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}