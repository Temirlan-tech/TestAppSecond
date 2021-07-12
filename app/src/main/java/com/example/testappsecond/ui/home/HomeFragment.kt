package com.example.testappsecond.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.widget.ViewPager2
import com.example.testappsecond.R
import com.example.testappsecond.data.FoodModel
import com.example.testappsecond.databinding.ActivityLaunchBinding.inflate
import com.example.testappsecond.databinding.FragmentHomeBinding
import com.example.testappsecond.databinding.IncludeHomeBinding

class HomeFragment : Fragment() {

    private lateinit var adapter: FoodAdapter
    private lateinit var adapterSecond: FoodAdapterSecond
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var uiBinding: IncludeHomeBinding
    private var binding: FragmentHomeBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = FoodAdapter(null)
        adapterSecond = FoodAdapterSecond(null)

        adapter.swapData(listOf(
            FoodModel(
                R.drawable.rectangle1,
                "Momos",
                "Japanese",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "30 min"
            ),

            FoodModel(
                R.drawable.rectangle2,
                "Beshbarmak",
                "KG",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "35 min"
            ),
            FoodModel(
                R.drawable.rectangle2,
                "Beshbarmak",
                "KG",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "40 min"
        )))

        adapterSecond.swapData(listOf(
            FoodModel(
                R.drawable.rectangle1,
                "Momos",
                "Japanese",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "30 min"
                ),

            FoodModel(
                R.drawable.rectangle2,
                "Beshbarmak",
                "KG",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "35 min"
            ),
            FoodModel(
                R.drawable.rectangle2,
                "Beshbarmak",
                "KG",
                "Delivery: Free • Minimum: 10$",
                R.id.imageViewStar,
                "4.5",
                R.id.time,
                "40 min"
            )))
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uiBinding = binding!!.includeHome
        uiBinding.recyclerView.adapter = adapter
        uiBinding.recyclerViewSecond.adapter = adapterSecond
    }

}