package com.example.karhabtifinal.ListesAnnonceInspectionMecanicien.Mecanicien

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Mecanicien.MecanicienDetail
import com.example.karhabtifinal.R
import com.example.karhabtifinal.data.*
import com.example.karhabtifinal.data.Mecanicien.*
import java.util.*


class MecanicienAdapter(val MecanicienList: MutableList<Mecanicien>, val context: Context) :
    RecyclerView.Adapter<MecanicienViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MecanicienViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mecanicien_single_item, parent, false)

        return MecanicienViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MecanicienViewHolder, position: Int) {

        val name = MecanicienList[position].name
        val adress = MecanicienList[position].adress
        val email = MecanicienList[position].email
        val phoneNumber = MecanicienList[position].phoneNumber
        val birthDate = MecanicienList[position].birthDate
        val image= MecanicienList[position].image


        holder.name.text = name
        holder.adress.text = adress
        holder.phoneNumber.text = phoneNumber

        val myByteArray = Base64.getDecoder().decode(image)
        loadImageToMovie(context, myByteArray, holder.pic, null)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MecanicienDetail::class.java)
            intent.apply {

                putExtra(PIC, image)
                putExtra(NAME, name)
                putExtra(ADRESS, adress)
                putExtra(EMAIL, email)
                putExtra(PHONENUMBER, phoneNumber)
                putExtra(BIRTHDATE, birthDate)

            }
            holder.itemView.context.startActivity(intent)
        }

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

    override fun getItemCount() = MecanicienList.size

}