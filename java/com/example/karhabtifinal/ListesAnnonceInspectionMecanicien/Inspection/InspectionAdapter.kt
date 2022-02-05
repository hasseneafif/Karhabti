package com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Inspection

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Inspection.DetailInspection
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.*
import com.example.karhabtifinal.data.Inspection.*


class InspectionAdapter(val InspectionList: MutableList<Inspection>) : RecyclerView.Adapter<InspectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspectionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.inspection_single_item, parent, false)

        return InspectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: InspectionViewHolder, position: Int) {

        val mecanicien = InspectionList[position].mecanicien
        val annonce = InspectionList[position].annonce
        val utilisateur = InspectionList[position].utilisateur
        val moteur = InspectionList[position].moteur
        val transmission = InspectionList[position].transmission
        val roues = InspectionList[position].roues
        val historique = InspectionList[position].historique
        val date = InspectionList[position].date



        holder.annonce.text = annonce
        holder.utilisateur.text = utilisateur
        holder.date.text = date


       holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailInspection::class.java)
            intent.apply {

                putExtra(ANNONCEINSP, annonce)
                putExtra(MECANICIENINSP, mecanicien)
                putExtra(UTILISATEURINSP, utilisateur)
                putExtra(MOTEUR, moteur)
                putExtra(TRANSMISSION, transmission)
                putExtra(ROUES, roues)
                putExtra(HISTORIQUE, historique)
                putExtra(DATEINSP, date)

            }
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount() = InspectionList.size

}