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
import com.jitusolution.s160420074.model.FavResto
import com.jitusolution.s160420074.model.Resto

class DetailViewModelFav(application: Application): AndroidViewModel(application) {
    val favrestoLD = MutableLiveData<FavResto>()
    val favrestoLoadErrorLD = MutableLiveData<Boolean>()
    val favloadingLD = MutableLiveData<Boolean>()


    private val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: String) {

            favloadingLD.value = true
            favrestoLoadErrorLD.value = false

            queue = Volley.newRequestQueue(getApplication())
            val url = "http://192.168.2.89/ubayakuliner/bestsellerresto/bestseller.php?id=$id"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                {

                    val sType = object : TypeToken<ArrayList<FavResto>>() {}.type
                    val result = Gson().fromJson<FavResto>(it, FavResto::class.java)
                    favrestoLD.value = result

                    favloadingLD.value = false
                    Log.d("showvoley", result.toString())

                },
                {
                    Log.d("showvoley", it.toString())
                    favrestoLoadErrorLD.value = false
                    favloadingLD.value = false
                })

            stringRequest.tag = TAG
            queue?.add(stringRequest)
        }



    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}

