package com.example.pizza_apps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pizza_apps.DataClass.PizzaList
import com.example.pizza_apps.databinding.CardviewBinding

class adapter(private val pizzaList: ArrayList<PizzaList>):RecyclerView.Adapter<adapter.ListViewHolder>() {
    private lateinit var clicked:OnItemClickCallBack
    fun setOnItemClicked(clicked: OnItemClickCallBack){
        this.clicked = clicked
    }
    interface OnItemClickCallBack {
        fun OnItemClicked(data: PizzaList)
    }
    class ListViewHolder (val binding:CardviewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = CardviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,desc,photo,desc_detail,price) = pizzaList[position]
        holder.binding.nameFood.text = name
        holder.binding.descList.text = desc
        holder.binding.imgVw.setImageResource(photo)
        holder.binding.click.text = desc_detail
        holder.binding.click.text = price
        holder.itemView.setOnClickListener {
            clicked.OnItemClicked(pizzaList[holder.adapterPosition])
        }
    }
}