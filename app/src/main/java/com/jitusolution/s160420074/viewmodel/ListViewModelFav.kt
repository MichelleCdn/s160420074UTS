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


class ListViewModelFav(application: Application): AndroidViewModel(application) {
    val favRestoLD = MutableLiveData<ArrayList<FavResto>>()
    val favRestoLoadErrorLD = MutableLiveData<Boolean>()
    val favloadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {

        favloadingLD.value = true
        favRestoLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.2.89/ubayakuliner/bestsellerresto/bestseller.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<FavResto>>() { }.type
                val result = Gson().fromJson<ArrayList<FavResto>>(it, sType)
                favRestoLD.value = result
                favloadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
                favRestoLoadErrorLD.value = true
                favloadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}