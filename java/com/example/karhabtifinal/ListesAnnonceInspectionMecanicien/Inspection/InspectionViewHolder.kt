package com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Inspection

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R


class InspectionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val annonce : TextView
    val utilisateur : TextView = itemView.findViewById<TextView>(R.id.utilisateur)
    val date : TextView = itemView.findViewById<TextView>(R.id.date)



    init {

        annonce = itemView.findViewById<TextView>(R.id.annonce)

    }

}