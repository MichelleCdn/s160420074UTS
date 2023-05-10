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


class ListViewModelRestoMenu(application: Application): AndroidViewModel(application) {
    val restoMenuLD = MutableLiveData<ArrayList<Menu>>()
    val restoMenuLoadErrorLD = MutableLiveData<Boolean>()
    val menuloadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null



    fun fetch(id: String) {

        menuloadingLD.value = true
        restoMenuLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.2.89/ubayakuliner/resto/menu.php?id=$id"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {

                val sType = object : TypeToken<ArrayList<Menu>>() { }.type
                val result = Gson().fromJson<ArrayList<Menu>>(it, sType)
                restoMenuLD.value = result
                menuloadingLD.value = false

                Log.d("showvoley", result.toString())

            },
            {
                Log.d("showvoley", it.toString())
                restoMenuLoadErrorLD.value = false
                menuloadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }


    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}