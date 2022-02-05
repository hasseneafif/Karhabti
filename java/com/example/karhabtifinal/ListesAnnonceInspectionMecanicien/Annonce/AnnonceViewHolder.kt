package com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Annonce

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R


class AnnonceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pic: ImageView
    val titre: TextView
    val marque: TextView = itemView.findViewById<TextView>(R.id.marque)
    val description: TextView = itemView.findViewById<TextView>(R.id.description)


    init {
        pic = itemView.findViewById<ImageView>(R.id.pic2)
        titre = itemView.findViewById<TextView>(R.id.titre)

    }

}