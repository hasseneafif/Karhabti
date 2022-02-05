package com.example.karhabtifinal.AccountsUtilisateurs

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.karhabtifinal.MainActivity
import com.example.karhabtifinal.network.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import com.example.karhabtifinal.R
import com.example.karhabtifinal.network.Retro
import com.example.karhabtifinal.network.UserApi
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_ajouter_annonce.*
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.util.*

class Signup : AppCompatActivity() {
    val pickImage = 100
    var imageUri: Uri? = null
    var stringUri: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var imageView: ImageView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
            initAction()

        }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            val imageUri: Uri? = data?.data
            val imageStream: InputStream? =
                contentResolver?.openInputStream(imageUri!!)
            val selectedImage = BitmapFactory.decodeStream(imageStream)
            imageView2.setImageBitmap(selectedImage)
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

        buttonSub.setOnClickListener {

            val email = loginEmail.text.toString().trim()
            val name = loginNom.text.toString().trim()
            val password = loginMdp.text.toString().trim()
            val confirmPassword = loginMdp2.text.toString().trim()
            val phoneNumber = loginNumber.text.toString().trim()
            val birthDate = loginDate.text.toString().trim()

             if(email.isEmpty()){
                  loginEmail.error="Email vide!"
                  loginEmail.requestFocus()
                  return@setOnClickListener
              }
              if(name.isEmpty()){
                  loginNom.error="Email vide!"
                  loginNom.requestFocus()
                  return@setOnClickListener
              }
              if(password.isEmpty()){
                  loginMdp.error="Mot de passe vide!"
                  loginMdp.requestFocus()
                  return@setOnClickListener
              }
              if(confirmPassword.isEmpty()){
                  loginMdp2.error="Confirm Mot de passe vide!"
                  loginMdp2.requestFocus()
                  return@setOnClickListener
              }
              if(phoneNumber.isEmpty()){
                  loginNumber.error="Numéro Télephone vide!"
                  loginNumber.requestFocus()
                  return@setOnClickListener
              }
              if(birthDate.isEmpty()){
                  loginDate.error="Date de naissance vide!"
                  loginDate.requestFocus()
                  return@setOnClickListener
              }
            Register()

        }
    }

    fun Register() {

        val paramObject1 = JSONObject()
        paramObject1.put("email", loginEmail.text.toString().trim())
        paramObject1.put("name", loginNom.text.toString().trim())
        paramObject1.put("password", loginMdp.text.toString().trim())
        paramObject1.put("confirmPassword", loginMdp2.text.toString().trim())
        paramObject1.put("phoneNumber", loginNumber.text.toString().trim())
        paramObject1.put("birthDate", loginDate.text.toString().trim())
        paramObject1.put("image", stringUri.trim())

        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retro().getRetroClientInstance().create(UserApi::class.java)

        retro.register(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {

                Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()
                initgo()
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
            }
        })
    }


    fun initgo() {

        val intent = Intent(this, MainActivity::class.java).apply { }
        startActivity(intent)

    }
}


