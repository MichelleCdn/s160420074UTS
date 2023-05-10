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
import com.jitusolution.s160420074.model.Resto


class ListViewModel(application: Application): AndroidViewModel(application) {
    val restoLD = MutableLiveData<ArrayList<Resto>>()
    val restoLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun refresh() {



        loadingLD.value = true
        restoLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.2.89/ubayakuliner/resto/resto.php"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Resto>>() { }.type
                val result = Gson().fromJson<ArrayList<Resto>>(it, sType)
                restoLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
                restoLoadErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)


    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}