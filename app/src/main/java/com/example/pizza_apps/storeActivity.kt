package com.example.pizza_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pizza_apps.databinding.ActivityStoreBinding

class storeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        click()
    }

    private fun click() {
        binding.seeBtn.setOnClickListener {
            val intent = Intent(this, listViewActivity::class.java)
            val name_user = binding.akunTv.text?.toString()
            intent.putExtra("EXTRA_USER",name_user)
            startActivity(intent)
        }
    }


    private fun getData() {
        val getName = intent.getStringExtra("EXTRA_USER")
        val getCity = intent.getStringExtra("EXTRA_SELECTED")
        binding.akunTv.text = getName
        binding.cityName.text = getCity
    }
}