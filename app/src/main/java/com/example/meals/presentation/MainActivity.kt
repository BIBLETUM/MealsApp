package com.example.meals.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.meals.databinding.ActivityMainBinding
import com.example.meals.presentation.adapters.MealAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as MealsApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        component.inject(this)

        val mealsAdapter = MealAdapter(this)
        binding.mealsRV.adapter = mealsAdapter
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.categoriesList.observe(this) {
            Log.d("cat", it.toString())
        }

        viewModel.mealsList.observe(this) {
            mealsAdapter.submitList(it)
        }
    }
}