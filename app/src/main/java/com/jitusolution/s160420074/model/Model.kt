package com.jitusolution.s160420074.model

import com.google.gson.annotations.SerializedName

data class Resto(
    val id:String?,
    val nama:String?,
    val jambukatutup:String?,
    val jarak:String?,
    val alamat:String?,
    val photourl:String?,
    val typefood: String?,
    val description: String?

)

data class FavResto(
    val id:String?,
    val nama:String?,
    val jambukatutup:String?,
    val jarak:String?,
    val alamat:String?,
    val photourl:String?,
    val typefood: String?,
    val description: String?
)

data class FavMenu(
   val id:String?,
   val nama:String?,
   val description:String?,
   val photourl:String?,
   val lokasi:String?
)

data class Menu(
    val id:String?,
    val nama:String?,
    val harga:String?,
    val description:String?,
    @SerializedName("photoUrl")
    val photourl:String?,
    @SerializedName("resto_id")
    val restoid:String?
)

data class Reviews(
    val id:String?,
    val nama:String?,
    val comment:String?,
    val bintang:String?,
    val tanggal:String?,
    @SerializedName("resto_id")
    val restoid:String?
)

