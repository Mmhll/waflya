package com.mhl.medit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.mhl.medit.retrofit.MyRetrofit
import com.mhl.medit.retrofit.login
import com.mhl.medit.retrofit.retrofit_api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
            val log = MyRetrofit().getRetrofit()
            val getApi = log.create(retrofit_api::class.java)
            var hashMap : HashMap<String, String> = HashMap<String, String>()
            hashMap.put("email", login)
            hashMap.put("password", password)
            val log_call : Call<login> = getApi.getAuth(hashMap)
            log_call.enqueue(object : Callback<login>{
                override fun onResponse(call: Call<login>, response: Response<login>) {
                    if (response.isSuccessful) {
                        val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@SignInActivity, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

            })
        }
        else{
           AlertDialog.Builder(this)
                .setTitle("????????????")
                .setMessage("?? ?????? ???????? ?????????????????????????? ????????")
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