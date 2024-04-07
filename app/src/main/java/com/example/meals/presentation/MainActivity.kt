package com.example.meals.presentation

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView.SmoothScroller
import com.example.meals.R
import com.example.meals.databinding.ActivityMainBinding
import com.example.meals.domain.Banner
import com.example.meals.domain.Category
import com.example.meals.presentation.adapters.BannerAdapter
import com.example.meals.presentation.adapters.CategoryAdapter
import com.example.meals.presentation.adapters.MealAdapter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    lateinit var banners: List<Banner>

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

        banners = listOf(
            Banner(1, R.drawable.banner1),
            Banner(2, R.drawable.banner2),
            Banner(3, R.drawable.banner3),
        )

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        initRVs()
        setUpToolBar()
    }

    private fun initRVs() {
        val bannerAdapter = BannerAdapter(this)
        binding.bannerRV.adapter = bannerAdapter
        bannerAdapter.submitList(banners)

        val mealsAdapter = MealAdapter(this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val smoothScroller: SmoothScroller = object : LinearSmoothScroller(this) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
        binding.mealsRV.layoutManager = layoutManager
        binding.mealsRV.adapter = mealsAdapter

        val categoryAdapter = CategoryAdapter()
        categoryAdapter.onCategoryClickListener = object : CategoryAdapter.OnCategoryClickListener {
            override fun onCategoryClick(category: Category) {
                val position = mealsAdapter.getFirstPositionOfCategory(category)
                if (position == -1) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.no_meals_for_this_category),
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }
                binding.appBar.setExpanded(false)
                smoothScroller.targetPosition = position
                layoutManager.startSmoothScroll(smoothScroller)
            }
        }
        binding.categoriesRV.itemAnimator = null
        binding.categoriesRV.adapter = categoryAdapter

        viewModel.categoriesList.observe(this) {
            categoryAdapter.submitList(it)
        }

        viewModel.mealsList.observe(this) {
            mealsAdapter.submitList(it)
        }
    }

    private fun setUpToolBar() {
        val data = arrayOf(
            getString(R.string.moscow),
            getString(R.string.kazan),
            getString(R.string.ufa)
        )
        val adapter = ArrayAdapter(
            this,
            R.layout.city_item,
            data
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.setAdapter(adapter)


        binding.spinner.setAdapter(adapter)
        binding.spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })
    }
}