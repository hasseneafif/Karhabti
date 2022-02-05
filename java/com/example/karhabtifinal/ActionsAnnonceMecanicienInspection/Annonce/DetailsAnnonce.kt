package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Annonce

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.Annonce.*
import com.example.karhabtifinal.data.Mecanicien.*
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.annonce_single_item.*
import java.util.*

class DetailsAnnonce :AppCompatActivity() {
    lateinit var image: ImageView
    lateinit var titre: TextView
    lateinit var marque: TextView
    lateinit var prix: TextView
    lateinit var date: TextView
    lateinit var gouvernorat: TextView
    lateinit var delegation: TextView
    lateinit var description: TextView

    @RequiresApi(Build.VERSION_CODES.O)
     fun onCreate(savedInstanceState: Bundle?,context: Context) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_annonce)

       //

        image = findViewById(R.id.PICDET)
        titre = findViewById(R.id.textTitle)
        marque = findViewById(R.id.textMarque)
        prix = findViewById(R.id.textPrix)
        date = findViewById(R.id.textDate)
        gouvernorat = findViewById(R.id.textGouvernorat)
        delegation = findViewById(R.id.textDELEGATION)
        description = findViewById(R.id.textDescription)

        val imagex = intent.getStringExtra(PICTURE)
        val titrex = intent.getStringExtra(TITRE)
        val marquex = intent.getStringExtra(MARQUE)
        val prixx = intent.getStringExtra(PRIX)
        val datex = intent.getStringExtra(DATE)
        val gouvernoratx = intent.getStringExtra(GOUVERNORAT)
        val delegationx = intent.getStringExtra(DELEGATION)
        val descriptionx = intent.getStringExtra(DESCRIPTION)


        titre.text = "$titrex"
        marque.text = "$marquex"
        prix.text = "$prixx"
        date.text = "$datex"
        gouvernorat.text = "$gouvernoratx"
        delegation.text = "$delegationx"
        description.text = "$descriptionx"
        val myByteArray = Base64.getDecoder().decode(imagex)
        loadImageToMovie(context, myByteArray, image, null)
        //image.setImageResource(intent.getIntExtra(PICTURE, 0))

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