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
import com.example.gwagou_bay.databinding.ActivityMainBinding
import com.example.gwagou_bay.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
//private lateinit var appBarConfiguration: AppBarConfiguration
//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)

        // injecter le fragment dans notre boîte (fragment_container)
        val transaction = supportFragmentManager.beginTransaction() // permet de stocker une valeur (qui ne changera pas) ; support fragment manager (permet de gérer les fragments sur android) ; .begintransaction => commence série d'opération pour gérer les fragments
        transaction.replace(R.id.fragment_container, HomeFragment()) // ici on remplace l'élément de gauche, par celui de droite (ici HomeFragment())
        transaction.addToBackStack(null) // permet de ne pas avoir de retour sur ce composant
        transaction.commit() // envoie les changements

        spotsRecords()
    }

 fun spotsRecords ()   {val spotsList = mutableMapOf(
        "spotOne" to mutableMapOf(
            "Surf Break" to "Reef Break",
            "Photos" to  "https://dl.airtable.com/ZuXJZ2NnTF40kCdBfTld_thomas-ashlock-64485-unsplash.jpg",
            "Address" to "Pipeline, Oahu, Hawaii"),
        "spotTwo" to mutableMapOf (
            "Surf Break" to "Point Break",
            "Photos" to "https://dl.airtable.com/e3QoP3cFSyykZJOvWGIy_cesar-couto-477018-unsplash%20(1).jpg",
            "Address" to "Supertubes, Jeffreys Bay, South Africa")
    )

    println(spotsList["spotOne"])}


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

