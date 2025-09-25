package com.example.d4aspostrecitos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.nav_view)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> { /* Abrir Home */ }
                R.id.nav_carrito -> { /* Abrir Carrito */ }
                R.id.nav_favoritos -> { /* Abrir Favoritos */ }
                R.id.nav_notificaciones -> { /* Abrir Notificaciones */ }
                R.id.nav_logout -> { finish() } // Cerrar sesión
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}
