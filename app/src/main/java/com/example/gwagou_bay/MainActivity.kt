
package com.example.gwagou_bay

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gwagou_bay.databinding.ActivityMainBinding
import com.example.gwagou_bay.fragments.AddSpotFragment
import com.example.gwagou_bay.fragments.HomeFragment
import com.example.gwagou_bay.fragments.SpotDetailsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
//private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(HomeFragment())

//        binding = ActivityMainBinding.inflate(layoutInflater)
        //import de la navbar
        val navigationView = findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnItemSelectedListener{
            when(it.itemId)
            {
                R.id.add_spot_page -> {
                    loadFragment(AddSpotFragment(this))
                    return@setOnItemSelectedListener true
                }
                R.id.settings_page -> {
                    loadFragment(SpotDetailsFragment(this))
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }


    }

    private fun loadFragment(fragment: Fragment) {



        // injecter le fragment dans notre boîte (fragment_container)
        val transaction = supportFragmentManager.beginTransaction() // permet de stocker une valeur (qui ne changera pas) ; support fragment manager (permet de gérer les fragments sur android) ; .begintransaction => commence série d'opération pour gérer les fragments
        transaction.replace(R.id.fragment_container, fragment) // ici on remplace l'élément de gauche, par celui de droite (ici HomeFragment())
        transaction.addToBackStack(null) // permet de ne pas avoir de retour sur ce composant
        transaction.commit() // envoie les changements

    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}

