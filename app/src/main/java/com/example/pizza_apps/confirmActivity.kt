package com.example.pizza_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pizza_apps.databinding.ActivityConfirmBinding

class confirmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val getName = intent.getStringExtra("EXTRA_USER")
        val getFood = intent.getStringExtra("EXTRA_NAME")
        binding.nameBook.text = getName
        binding.nameOrder.setText("$getFood Sudah diTambahkan Kedalam Pesanan")
        binding.doneBtn.setOnClickListener {
            val intent = Intent(this,listViewActivity::class.java)
            Toast.makeText(applicationContext,"Pesanan Sudah Ditambahkan \n${getFood.toString()} \n",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }
}