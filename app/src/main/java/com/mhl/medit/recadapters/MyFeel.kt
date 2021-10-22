package com.mhl.medit.recadapters

import com.mhl.medit.R

data class feel(val image:Int, val name_feel:String)
class MyFeel{
    val list = arrayListOf(
        feel(R.drawable.ic, "Спокойным"),
        feel(R.drawable.relax, "Расслабленным"),
        feel(R.drawable.focus, "Сосредоточенным"),
        feel(R.drawable.anxious, "Взволнованным"))
}
