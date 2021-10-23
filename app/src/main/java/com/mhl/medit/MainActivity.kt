package com.mhl.medit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mhl.medit.retrofit.MyRetrofit
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun login(view: View) {
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}