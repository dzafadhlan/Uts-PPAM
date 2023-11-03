package com.example.pizza_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.pizza_apps.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewCreate()
    }

    private fun viewCreate() {

        binding.submitBtn.setOnClickListener {
            val intent = Intent(this,storeActivity::class.java)
            val name_user = binding.textField.editText?.text.toString()
            val city_user = binding.spinnerStr.selectedItem.toString()
            intent.putExtra("EXTRA_USER",name_user)
            intent.putExtra("EXTRA_SELECTED", city_user)
            startActivity(intent)
        }
    }
}