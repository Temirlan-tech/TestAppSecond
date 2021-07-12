package com.example.testappsecond.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappsecond.data.FoodModel
import com.example.testappsecond.databinding.ItemFoodBinding
import com.example.testappsecond.databinding.ItemFoodSecondBinding

class FoodAdapterSecond(
    private var foodData: List<FoodModel>?
) : RecyclerView.Adapter<FoodAdapterSecond.ViewHolder>() {

    inner class ViewHolder(private val databinding: ItemFoodSecondBinding)
        :RecyclerView.ViewHolder(databinding.root) {

        fun onBind(foodItem: FoodModel?) {
            Log.e("TAG", "onBind:${foodItem?.imageRes} " )
            databinding.imageFood.setImageResource(foodItem?.imageRes ?: 0)
            databinding.textFoodName.text = foodItem?.foodName ?: ""
            databinding.textCountry.text = foodItem?.country ?: ""
        }
    }

    fun swapData(foodData: List<FoodModel>?) {
        this.foodData = foodData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapterSecond.ViewHolder {
        return ViewHolder(
            ItemFoodSecondBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodAdapterSecond.ViewHolder, position: Int) {
        if (foodData != null) {
            holder.onBind(foodData?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return foodData?.size ?: 0
    }
}