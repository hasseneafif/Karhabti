package com.example.karhabtifinal.ActionsAnnonceMecanicienInspection.Annonce

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.fragment_ajouter_annonce.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.graphics.drawable.Drawable
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.karhabtifinal.R
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*


class AjouterAnnonceFragment : Fragment() {
    val pickImage = 100
    var imageUri: Uri? = null
    var stringUri: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lateinit var imageView: ImageView
        val view = inflater.inflate(R.layout.fragment_ajouter_annonce, container, false)

        val imageView2 = view?.findViewById<ImageView>(R.id.Addimage)
        imageView2?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        initAction()
        val button = view?.findViewById<Button>(R.id.Addbutton)
        button?.setOnClickListener {
            val titre = Addtitre.text.toString().trim()
            val marque = Addmarque.text.toString().trim()
            val prix = Addprix.text.toString().trim()
            val date = Adddate.text.toString().trim()
            val gouvernorat = Addgouvernorat.text.toString().trim()
            val delegation = Adddelegation.text.toString().trim()
            val description = Adddescription.text.toString().trim()

            if (titre.isEmpty()) {
                Addtitre.error = "Titre vide!"
                Addtitre.requestFocus()
                return@setOnClickListener
            }
            if (titre.isEmpty()) {
                Addtitre.error = "Titre vide!"
                Addtitre.requestFocus()
                return@setOnClickListener
            }
            if (marque.isEmpty()) {
                Addmarque.error = "Email vide!"
                Addmarque.requestFocus()
                return@setOnClickListener
            }
            if (prix.isEmpty()) {
                Addprix.error = "Prix vide!"
                Addprix.requestFocus()
                return@setOnClickListener
            }
            if (date.isEmpty()) {
                Adddate.error = "Date vide!"
                Adddate.requestFocus()
                return@setOnClickListener
            }
            if (gouvernorat.isEmpty()) {
                Addgouvernorat.error = "Gouvernorat vide!"
                Addgouvernorat.requestFocus()
                return@setOnClickListener
            }
            if (delegation.isEmpty()) {
                Adddelegation.error = "Delegation vide!"
                Adddelegation.requestFocus()
                return@setOnClickListener
            }
            if (description.isEmpty()) {
                Adddescription.error = "Description vide!"
                Adddescription.requestFocus()
                return@setOnClickListener
            }
//                if(image.isEmpty()){
//                    Addimage.c="Date de naissance vide!"
//                    Addimage.requestFocus()
//                    return@setOnClickListener
//        }
            stores()
        }
        return view

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            val imageUri: Uri? = data?.data
            val imageStream: InputStream? =
                activity?.contentResolver?.openInputStream(imageUri!!)
            val selectedImage = BitmapFactory.decodeStream(imageStream)
            Addimage.setImageBitmap(selectedImage)
            val baos = ByteArrayOutputStream()
            selectedImage?.compress(Bitmap.CompressFormat.PNG, 100, baos)
            stringUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Base64.getEncoder().encodeToString(baos.toByteArray())
            } else {
                TODO("VERSION.SDK_INT < O")
            }
//            val myByteArray = Base64.getDecoder().decode(byteString)
//            loadImage(requireContext(), myByteArray, binding.secondImage, ContextCompat.getDrawable(requireContext(), R.drawable.myimage))

//            imageUri = data?.data
//            Addimage.setImageURI(imageUri)
//            Addimage.drawable
//            stringUri = downloadImage(context,Addimage.drawable).toString()


        }
    }
    ///Base64.getEncoder().encodeToString(baos.toByteArray())


    fun downloadImage(context: Context?, d: Drawable): ByteArray? {
        val bitmap: Bitmap = drawableToBitmap(d)
        val baos = ByteArrayOutputStream()

        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, baos)
        baos.flush();
        baos.close();
        baos.close();
        return baos.toByteArray()
    }

    fun drawableToBitmap(drawable: Drawable): Bitmap {

        var bitmap: Bitmap? = null
        if (drawable is BitmapDrawable) {
            val bitmapDrawable = drawable
            if (bitmapDrawable.bitmap != null) {
                return bitmapDrawable.bitmap
            }
        }
        bitmap = if (drawable.intrinsicWidth <= 0 || drawable.intrinsicHeight <= 0) {
            Bitmap.createBitmap(
                1,
                1,
                Bitmap.Config.ARGB_8888
            ) // Single color bitmap will be created of 1x1 pixel
        } else {
            Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
        }
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)
        return bitmap
    }

    fun initAction() {
        val button = view?.findViewById<Button>(R.id.Addbutton)
        button?.setOnClickListener {
            val titre = Addtitre.text.toString().trim()
            val marque = Addmarque.text.toString().trim()
            val prix = Addprix.text.toString().trim()
            val date = Adddate.text.toString().trim()
            val gouvernorat = Addgouvernorat.text.toString().trim()
            val delegation = Adddelegation.text.toString().trim()
            val description = Adddescription.text.toString().trim()
            val image = Addimage.imageView.toString().trim()

            if (titre.isEmpty()) {
                Addtitre.error = "Titre vide!"
                Addtitre.requestFocus()
                return@setOnClickListener
            }
            if (marque.isEmpty()) {
                Addmarque.error = "Email vide!"
                Addmarque.requestFocus()
                return@setOnClickListener
            }
            if (prix.isEmpty()) {
                Addprix.error = "Prix vide!"
                Addprix.requestFocus()
                return@setOnClickListener
            }
            if (date.isEmpty()) {
                Adddate.error = "Date vide!"
                Adddate.requestFocus()
                return@setOnClickListener
            }
            if (gouvernorat.isEmpty()) {
                Addgouvernorat.error = "Gouvernorat vide!"
                Addgouvernorat.requestFocus()
                return@setOnClickListener
            }
            if (delegation.isEmpty()) {
                Adddelegation.error = "Delegation vide!"
                Adddelegation.requestFocus()
                return@setOnClickListener
            }
            if (description.isEmpty()) {
                Adddescription.error = "Description vide!"
                Adddescription.requestFocus()
                return@setOnClickListener
            }
//                if(image.isEmpty()){
//                    Addimage.c="Date de naissance vide!"
//                    Addimage.requestFocus()
//                    return@setOnClickListener
//        }

        }
    }

    fun stores() {
        val paramObject2 = JSONObject()
        paramObject2.put("titre", Addtitre.text.toString().trim())
        paramObject2.put("marque", Addmarque.text.toString().trim())
        paramObject2.put("prix", Addprix.text.toString().trim())
        paramObject2.put("date", Adddate.text.toString().trim())
        paramObject2.put("gouvernorat", Addgouvernorat.text.toString().trim())
        paramObject2.put("delegation", Adddelegation.text.toString().trim())
        paramObject2.put("description", Adddescription.text.toString().trim())
        paramObject2.put("image", stringUri.trim())


        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject2.toString()) as JsonObject
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)

        retro.stores(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                initgo()
                Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()

            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }





    fun initgo() {
        //   (activity as MainActivity?)?.replacefragment(AnnoncesFragment())
    }
}