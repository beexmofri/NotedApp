package com.example.roomapp.fragments.login

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.roomapp.R
import com.example.roomapp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("DATA_INFO", Context.MODE_PRIVATE)

        binding.btnlogin.setOnClickListener {
            val str_email = binding.etemail.text.toString()
            val str_pass = binding.etpassword.text.toString()

            if(str_email.isNullOrEmpty() || str_pass.isNullOrEmpty()){
                Toast.makeText(activity, "Masukan Informasi", Toast.LENGTH_SHORT).show()
            }else{
                val email_id = sharedPreferences.getString("email", "defaultEmail")
                val password = sharedPreferences.getString("pass", "defaultPass")

                if (email_id.equals(str_email) && password.equals(str_pass)){
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.apply()
                   it.findNavController().navigate(R.id.action_loginFragment_to_listFragment)
                }else{
                    Toast.makeText(activity, "Data Kosong", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btntvreg.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}