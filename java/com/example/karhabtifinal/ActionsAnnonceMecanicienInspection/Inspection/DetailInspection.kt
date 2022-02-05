package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Inspection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.*
import com.example.karhabtifinal.data.Inspection.*


class DetailInspection : AppCompatActivity() {

    //lateinit var pic : ImageView
    lateinit var annonce : TextView
    lateinit var utilisateur : TextView
    // lateinit var mecanicien : TextView
    //  lateinit var moteur : TextView
    //  lateinit var roues : TextView
//    lateinit var transmission : TextView
    //lateinit var historique : TextView
    lateinit var date : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_inspection)


        // pic = findViewById(R.id.pic2)
        annonce = findViewById(R.id.annonce)
        //transmission = findViewById(R.id.transmission)
        // mecanicien = findViewById(R.id.mecanicien)
        utilisateur = findViewById(R.id.utilisateur)
        // moteur = findViewById(R.id.moteur)
        // roues = findViewById(R.id.roues)
        //historique = findViewById(R.id.historique)
        date = findViewById(R.id.date)

        //  pic.setImageResource(intent.getIntExtra(PICTUREINSP, 0))

        val annoncex = intent.getStringExtra(ANNONCEINSP)
        val transmissionx = intent.getStringExtra(TRANSMISSION)
        val mecanicienx = intent.getStringExtra(MECANICIENINSP)
        val utilisateurx = intent.getStringExtra(UTILISATEURINSP)
        val datex = intent.getStringExtra(DATEINSP)
        val moteurx = intent.getStringExtra(MOTEUR)
        val rouesx = intent.getStringExtra(ROUES)
        val historiquex = intent.getStringExtra(HISTORIQUE)







        annonce.text = "$annoncex"
        //  transmission.text = "$transmissionx"
        //  mecanicien.text = "$mecanicienx"
        utilisateur.text = "$utilisateurx"
        //   moteur.text = "$moteurx"
        //  roues.text = "$rouesx"
        //  historique.text = "$historiquex"
        date.text = "$datex"

    }
}