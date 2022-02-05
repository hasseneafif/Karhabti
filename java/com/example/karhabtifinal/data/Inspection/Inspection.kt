package com.example.karhabtifinal.data.Inspection



import androidx.annotation.DrawableRes

//const val PICINSP = "PICTURE"
const val MECANICIENINSP = "MECANICIEN"
const val ANNONCEINSP = "ANNONCE"
const val UTILISATEURINSP = "UTILISATEUR"
const val MOTEUR = "MOTEUR"
const val TRANSMISSION = "TRANSMISSION"
const val ROUES = "ROUES"
const val HISTORIQUE = "HISTORIQUE"
const val DATEINSP = "DATE"

data class Inspection(



    val mecanicien: String,

    val annonce: String,

    val utilisateur: String,

    val moteur: String,

    val transmission: String,

    val roues: String,

    val historique: String,

    val date: String

)