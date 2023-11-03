package com.example.pizza_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pizza_apps.databinding.ActivityDetailedBinding

class detailedActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        click()
    }

    private fun click() {
        binding.btnOrder.setOnClickListener {
            val name_user = binding.akunTv.text?.toString()
            val food_name = binding.namePizza.text.toString()
            val intent = Intent(this,confirmActivity::class.java)
            intent.putExtra("EXTRA_USER", name_user)
            intent.putExtra("EXTRA_NAME", food_name)
            startActivity(intent)

        }
    }

    private fun getData() {
        val receiver_user = intent.getStringExtra("NAME_USER")
        val receiver_name = intent.getStringExtra("NAME_FOOD")
        val receiver_desc = intent.getStringExtra("DESC_FOOD")
        val receiver_price = intent.getStringExtra("PRICE_FOOD")
        val receiver_photo = intent.getIntArrayExtra("IMG_FOOD")
        binding.akunTv.text = receiver_user
        binding.namePizza.text = receiver_name
        binding.deskripsi.text = receiver_desc
        binding.price.text = receiver_price
    }
}