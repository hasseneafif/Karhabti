package com.example.karhabtifinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.karhabtifinal.databinding.ActivityMainBinding
import com.example.karhabtifinal.databinding.ActivityMainMecanicienBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivityMecanicien : AppCompatActivity() {
    private lateinit var binding: ActivityMainMecanicienBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMecanicienBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)
    }



}