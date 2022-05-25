package com.example.roomapp.fragments.splashscreen

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R

class SplashScreenFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            val view = inflater.inflate(R.layout.fragment_splash_screen, container, false)

            val sharedPreferences: SharedPreferences =
                requireActivity().getSharedPreferences("DATA_INFO", AppCompatActivity.MODE_PRIVATE)

            val email = sharedPreferences.getString("email", null)

            if (email != null){
                findNavController().navigate(R.id.action_splashScreenFragment_to_listFragment)
            } else {
                Handler(Looper.myLooper()!!).postDelayed({
                    findNavController().navigate(R.id.action_splashScreenFragment_to_loginFragment)
                }, 2000)
            }
            return view
        }
    }