package com.example.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.roomapp.model.User
import com.example.roomapp.viewmodel.UserViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user : User = get()
//        println("TEST : ${user.tittle}, ${user.note}")
        Toast.makeText(this, "${user.tittle}, ${user.note}", Toast.LENGTH_LONG).show()



        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}