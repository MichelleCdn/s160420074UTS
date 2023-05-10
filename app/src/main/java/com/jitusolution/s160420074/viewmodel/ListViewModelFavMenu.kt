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
import com.jitusolution.s160420074.model.FavMenu
import com.jitusolution.s160420074.model.FavResto
import com.jitusolution.s160420074.model.Resto


class ListViewModelFavMenu(application: Application): AndroidViewModel(application) {
    val favMenuLD = MutableLiveData<ArrayList<FavMenu>>()
    val favMenuLoadErrorLD = MutableLiveData<Boolean>()
    val favMenuloadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {


        favMenuloadingLD.value = true
        favMenuLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.2.89/ubayakuliner/bestsellermenu/bestsellermenu.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<FavMenu>>() { }.type
                val result = Gson().fromJson<ArrayList<FavMenu>>(it, sType)
                favMenuLD.value = result
                favMenuloadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
                favMenuLoadErrorLD.value = true
                favMenuloadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}