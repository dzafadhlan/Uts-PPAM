package com.example.pizza_apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza_apps.DataClass.PizzaList
import com.example.pizza_apps.adapter.adapter
import com.example.pizza_apps.databinding.ActivityListViewBinding
import com.example.pizza_apps.databinding.ActivityStoreBinding

class listViewActivity : AppCompatActivity() {
    val data =ArrayList<PizzaList>()
    private lateinit var binding: ActivityListViewBinding
    private lateinit var listFood:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listFood =binding.rView
        listFood.setHasFixedSize(true)
        data.addAll(getAllData())
        viewCycle()

    }


    private fun viewCycle() {
        binding.rView.layoutManager =LinearLayoutManager(this)
        val listData = adapter(data)
        binding.rView.adapter = listData
        val getName = intent.getStringExtra("EXTRA_USER")
        binding.nameUser.text = getName
        val sendName = binding.nameUser.text?.toString()
        listData.setOnItemClicked(object : adapter.OnItemClickCallBack{
            override fun OnItemClicked(data: PizzaList) {
                val intent = Intent(this@listViewActivity,detailedActivity::class.java)
                intent.putExtra("NAME_FOOD",data.name)
                intent.putExtra("DESC_FOOD",data.desc_detail)
                intent.putExtra("IMG_FOOD",data.img)
                intent.putExtra("PRICE_FOOD",data.price)
                intent.putExtra("NAME_USER",sendName)
                startActivity(intent)
            }
        })
    }

    private fun getAllData(): Collection<PizzaList> {
        val name_food =resources.getStringArray(R.array.name_pizza)
        val desc_food = resources.getStringArray(R.array.desc)
        val img_food = resources.obtainTypedArray(R.array.img_food)
        val desc_detail = resources.getStringArray(R.array.desc_detail)
        val price = resources.getStringArray(R.array.price)
        val listData = ArrayList<PizzaList>()
        for (i in name_food.indices){
            val data = PizzaList(name_food[i],desc_food[i],img_food.getResourceId(i,-1),desc_detail[i],price[i])
            listData.add(data)
        }
        return listData
    }
}