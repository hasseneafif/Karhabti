package com.example.karhabtifinal.AccountsUtilisateurs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.karhabtifinal.R
import com.example.karhabtifinal.MainActivity
import com.example.karhabtifinal.MainActivityMecanicien
import com.example.karhabtifinal.data.Utilisateur.User
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initAction()
    }


    fun initAction() {
        buttonSuiv.setOnClickListener {
            val Email = loginemail.text.toString().trim()
            val mdp = loginpassw.text.toString().trim()
            if (Email.isEmpty()) {
                loginemail.error = "Email vide!"
                loginemail.requestFocus()
                return@setOnClickListener
            }
            if (mdp.isEmpty()) {
                loginpassw.error = "Mot de passe vide!"
                loginpassw.requestFocus()
                return@setOnClickListener
            }
            login()
        }
    }

    fun login() {
        val paramObject1 = JSONObject()
        paramObject1.put("email", loginemail.text.toString().trim())
        paramObject1.put("password", loginpassw.text.toString().trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)

        retro.login(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if (response.code() == 200) {
                    val role = response.body()?.get("role").toString()
                    if (role == "\"mecanicien\"") {
                        navigate()

                    }
                    //else if (!role == "\"mecanicien\"") {
                    else if (!role.equals( "\"mecanicien\"")) {
                        navigate2()
                    }
                    Toast.makeText(applicationContext, "go", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "we can't sorry", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }


    fun navigate(){

        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)

    }
    fun navigate2(){

        val intent = Intent(this, MainActivityMecanicien::class.java).apply { }
        startActivity(intent)
    }


    fun initgo() {

    }

}


//        val request = UserRequest()
//       request.email = loginemail.text.toString().trim()
//       request.password= loginpassw.text.toString().trim()
//
//       val retro = Retro().getRetroClientInstance().create(UserApi::class.java)
//       retro.login(request).enqueue(object : retrofit2.Callback<UserResponse> {
//
//           override fun onFailure(call: Call<UserResponse>, t: Throwable) {
//               Log.d("auth", "ffff")
//               t.message?.let { Log.d("auth", it)
//                   initgo()
//               }
//           }
//
//           override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
//               Log.d("auth", response.code().toString())
//
//           }
//
//       })
//   }
//
//    fun initgo() {
//        val intent = Intent(this, MainActivity::class.java).apply { }
//        startActivity(intent)
//    }
//

