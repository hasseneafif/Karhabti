package com.example.karhabtifinal.AccountsUtilisateurs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.karhabtifinal.R


class ChoisirLoginSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choisirloginsignup)
        val button: ImageView = findViewById(R.id.imageView2)
        val button2: TextView = findViewById(R.id.textView9)

        button.setOnClickListener {
            val intent = Intent(this, Signup::class.java).apply { }
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, Login::class.java).apply { }
            startActivity(intent)


        }


    }

}
