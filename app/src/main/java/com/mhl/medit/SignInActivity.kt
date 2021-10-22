package com.mhl.medit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {
    private lateinit var loginText : EditText
    private lateinit var passwordText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        loginText = findViewById(R.id.email)
        passwordText = findViewById(R.id.password)
    }
    val pattern : Pattern = Pattern.compile(
        "[a-zA-Z0-9\\.\\-\\_]{4,50}"
                +"\\@"
                +"[a-zA-Z\\-]{2,15}"
                +"\\."
                +"[a-zA-Z]{2,10}"
    )
    fun signin(view: View) {
        var login = loginText.text.toString()
        var password = passwordText.text.toString()
        if (login.isNotEmpty() && password.isNotEmpty()) {
            val intent = Intent(this, MenuActivity::class.java)
        }
        else{
           AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
    fun check(email : String): Boolean {
        return pattern.matcher(email).matches()
    }
    fun Register(view: View) {

    }
}