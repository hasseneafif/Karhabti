package com.example.karhabtifinal.data.Annonce


const val PICTURE = "PICTURE"
const val TITRE = "TITRE"
const val MARQUE = "MARQUE"
const val DESCRIPTION = "DESCRIPTION"
const val DATE = "DATE"
const val PRIX = "PRIX"
const val GOUVERNORAT = "GOUVERNORAT"
const val DELEGATION = "DELEGATION"

data class Annonce(

    val image: String,

    val titre: String,

    val marque: String,

    val prix: String,

    val date: String,

    val gouvernorat: String,

    val delegation: String,

    val description: String



)