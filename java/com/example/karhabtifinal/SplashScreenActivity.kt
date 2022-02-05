package com.example.karhabtifinal

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.karhabtifinal.AccountsUtilisateurs.ChoisirLoginSignup


class SplashScreenActivity : AppCompatActivity() {

    // This is the loading time of the splash screen
    private val SPLASH_TIME_OUT: Long = 2500 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, ChoisirLoginSignup::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}