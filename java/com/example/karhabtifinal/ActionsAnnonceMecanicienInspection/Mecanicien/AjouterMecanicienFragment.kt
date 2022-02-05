package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Mecanicien

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.karhabtifinal.R
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_mecanicien_detail.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AjouterMecanicienFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ajouter_mecanicien, container, false)
        initAction()
        val button = view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {


            val name = name.text.toString().trim()
            val adress = adress.text.toString().trim()
            val email = email.text.toString().trim()
            val phoneNumber = phoneNumber.text.toString().trim()
            val birthDate = birthDate.text.toString().trim()

            /*if (name.isEmpty()) {
                name.error = "Titre vide!"
                name.requestFocus()
                return@setOnClickListener
            }*/
            stores()

        }
        return view
    }

    fun initAction() {
        val button = view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {
            val name = name.text.toString().trim()
            val adress = adress.text.toString().trim()
            val email = email.text.toString().trim()
            val phoneNumber = phoneNumber.text.toString().trim()
            val birthDate = birthDate.text.toString().trim()

            /*if (name.isEmpty()) {
                name.error = "Titre vide!"
                name.requestFocus()
                return@setOnClickListener*/
        }


    }


    fun stores() {
        val paramObject2 = JSONObject()
        paramObject2.put("name", name.text.toString().trim())
        paramObject2.put("adress", adress.text.toString().trim())
        paramObject2.put("email", email.text.toString().trim())
        paramObject2.put("phoneNumber", phoneNumber.text.toString().trim())
        paramObject2.put("birthDate", birthDate.text.toString().trim())

        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject2.toString()) as JsonObject
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)

        retro.store2(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                initgo()
                Toast.makeText(context, "go", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }


    fun initgo() {
//        (activity as MainActivity?)?.replacefragment(AnnoncesFragment())
    }
}
