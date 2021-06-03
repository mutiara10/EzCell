package com.example.ezcell

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val tool = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tool)


        val navController: NavController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration: AppBarConfiguration = AppBarConfiguration.Builder(
            R.id.lg_home, R.id.lg_camera, R.id.lg_history, R.id.lg_profil
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)

        val navigasiBawah = findViewById<BottomNavigationView>(R.id.navigasi_bawah)
        navigasiBawah.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pilihan, menu)
        return true

    }
}

