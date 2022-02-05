package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Mecanicien

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.*
import com.example.karhabtifinal.data.Annonce.PICTURE
import com.example.karhabtifinal.data.Mecanicien.*
import java.util.*


class MecanicienDetail : AppCompatActivity() {



    lateinit var pic : ImageView
    lateinit var name : TextView
    lateinit var adress : TextView
    lateinit var email: TextView
    lateinit var phoneNumber : TextView

    lateinit var birthDate : TextView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mecanicien_detail)


        pic = findViewById(R.id.pic22)
        name = findViewById(R.id.name)
        adress = findViewById(R.id.adress)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phoneNumber)
        birthDate = findViewById(R.id.birthDate)

        //pic.setImageResource(intent.getIntExtra(PIC, 0))

        val namex = intent.getStringExtra(NAME)
        val adressx = intent.getStringExtra(ADRESS)
        val emailx = intent.getStringExtra(EMAIL)
        val phoneNumberx = intent.getStringExtra(PHONENUMBER)
        val birthDatex = intent.getStringExtra(BIRTHDATE)


        name.text = "$namex"
        adress.text = "$adressx"
        email.text = "$emailx"
        phoneNumber.text = "$phoneNumberx"
        birthDate.text = "$birthDatex"
        val myByteArray = Base64.getDecoder().decode(PIC)
        loadImageToMovie(getApplicationContext(), myByteArray, pic, null)

    }
    fun loadImageToMovie(
        context: Context,
        source: ByteArray,
        target: ImageView,
        placeholder: Drawable?
    ) {
        if (source == null) {
            Glide.with(context).load(placeholder).into(target)
        } else {
            Glide.with(context).load(source).placeholder(placeholder).error(placeholder)
                .into(target)
        }
    }
}