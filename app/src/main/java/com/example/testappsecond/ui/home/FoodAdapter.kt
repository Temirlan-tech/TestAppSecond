package com.example.testappsecond.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappsecond.data.FoodModel
import com.example.testappsecond.databinding.ItemFoodBinding

class FoodAdapter(
    private var foodData: List<FoodModel>?
) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(private val databinding: ItemFoodBinding)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        return ViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        if (foodData != null) {
            holder.onBind(foodData?.get(position))
        }
    }

    override fun getItemCount(): Int {
        return foodData?.size ?: 0
    }
}