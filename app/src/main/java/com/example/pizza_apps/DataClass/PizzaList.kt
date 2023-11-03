package com.example.pizza_apps.DataClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class PizzaList(
    val name:String, val des:String, val img:Int, val desc_detail:String, val price:String
):Parcelable
