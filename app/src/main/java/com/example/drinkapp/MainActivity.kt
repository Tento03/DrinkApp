package com.example.drinkapp

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.collection.arraySetOf
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.drinkapp.databinding.ActivityMainBinding
import com.example.drinkapp.drink.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<DrinkViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView:BottomNavigationView=binding.navView
        val navController=findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration= AppBarConfiguration(
            arraySetOf(R.id.navigation_home,R.id.navigation_favorite,R.id.navigation_details)
        )
        setupActionBarWithNavController(navController,appBarConfiguration)
        navView.setupWithNavController(navController)
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.search_menu, menu) // Inflate menu sebelum return
//        val searchItem = menu?.findItem(R.id.action_search)
//        val searchView = searchItem?.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return true
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                if (newText != null) {
//                    viewModel.searchDrink(newText)
//                }
//                return true
//            }
//        })
//
//        return true // Return true agar menu ditampilkan
//    }
}