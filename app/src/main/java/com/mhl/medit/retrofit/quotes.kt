package com.mhl.medit.retrofit

data class quotes(val success : Boolean, val arrayQuotes : ArrayList<data_quotes>)
data class data_quotes(val id : Int, val title : String, val image : String, val description : String)
