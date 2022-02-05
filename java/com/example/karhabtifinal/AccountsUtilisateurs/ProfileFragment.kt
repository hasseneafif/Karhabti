package com.example.karhabtifinal.AccountsUtilisateurs

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.karhabtifinal.R
import com.example.karhabtifinal.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.buttonModifierProfile.setOnClickListener {
            findNavController().navigate(R.id.profile_to_modifierprofile)
        }


//        val namex = getStringExtra(NAME)
//        val adressx = intent.getStringExtra(ADRESS)
//        val emailx = intent.getStringExtra(EMAIL)
//        val phoneNumberx = intent.getStringExtra(PHONENUMBER)

//        usernom.text = "$namex"
//        useremail.text = "$adressx"
//        usernumero.text = "$emailx"
//        userdate.text = "$phoneNumberx"
        return binding.root

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


//        binding.buttonModifierProfile.setOnClickListener {
//            //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
