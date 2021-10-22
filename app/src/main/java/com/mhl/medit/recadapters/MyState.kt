package com.mhl.medit.recadapters

import com.mhl.medit.R

data class state(val title: String, val text_state: String, val image_state : Int)
class MyState{
    val state_list = arrayListOf(
        state("Заголовок блока", "Краткое описание", R.drawable.state1),
        state("Заголовок блока", "Краткое описание", R.drawable.state2)
    )
}