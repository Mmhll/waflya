package com.mhl.medit.retrofit

import android.widget.ImageView

data class feelings(val success : Boolean, val data : ArrayList<feel_data>)
data class feel_data(val id : Int, val title : String, val image : String, val position : Int)
