package com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Mecanicien

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.R


class MecanicienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val pic: ImageView

    val name: TextView
    val adress: TextView = itemView.findViewById<TextView>(R.id.adress)
    val phoneNumber: TextView = itemView.findViewById<TextView>(R.id.phoneNumber)


    init {
        pic = itemView.findViewById<ImageView>(R.id.shop2)
        name = itemView.findViewById<TextView>(R.id.name)

    }

}