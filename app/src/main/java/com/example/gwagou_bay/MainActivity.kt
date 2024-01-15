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
import com.example.gwagou_bay.fragments.SpotDetailsFragment

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response

import org.json.JSONObject



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)

        // injecter le fragment dans notre boîte (fragment_container)
        val transaction =
            supportFragmentManager.beginTransaction() // permet de stocker une valeur (qui ne changera pas) ; support fragment manager (permet de gérer les fragments sur android) ; .begintransaction => commence série d'opération pour gérer les fragments
        transaction.replace(
            R.id.fragment_container,
            HomeFragment(this)
        ) // ici on remplace l'élément de gauche, par celui de droite (ici HomeFragment())
        transaction.addToBackStack(null) // permet de ne pas avoir de retour sur ce composant
        transaction.commit() // envoie les changements

        // Call the function to make the GET request
        makeGetRequest()


    }

    //function pour appel API qui retourne les datas au format json
    private fun makeGetRequest() {
        // Create an OkHttpClient instance
        val client = OkHttpClient()

        // Replace the URL with the desired endpoint
        val url = "https://api.airtable.com/v0/apptEhqmwsc6jfuFF/Surf%20Destinations"


        // Create a request using the GET method
        val request = Request.Builder()
            .url(url)
            .addHeader("Authorization", "Bearer patFMjbuBugC4G7A9.4454f5c043b6529a54444d7971322e5303cbb8747b789545274aef5665eb016b")
            .addHeader("Cookie", "brw=brw2kYa4jmxqyLpd8; AWSALB=U26ouxw7j4ohFlExmNudgtGDG0bN6eC483Q2k5nSShiBWxRhFnxsw4NJi37lttLMGRR/b/As4XMsQuipbnIScu09XkTE1Fay8tDgCV8Z/vXJdwmb6gM3BYoOGDN4; AWSALBCORS=U26ouxw7j4ohFlExmNudgtGDG0bN6eC483Q2k5nSShiBWxRhFnxsw4NJi37lttLMGRR/b/As4XMsQuipbnIScu09XkTE1Fay8tDgCV8Z/vXJdwmb6gM3BYoOGDN4")
            .get()
            .build()


        // Execute the request and handle the response asynchronously
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                // Handle failure
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                // Handle successful response

                val responseData = response.body?.string()

                runOnUiThread {
                    // Update UI or perform other tasks with the response data
                    println(responseData)
                    if (responseData != null) {
                        parseJSON(responseData)
                    }
                }


                // Close the response body
                response.close()
            }
        })
    }
    // Create the function which can parse the
    fun parseJSON(jsonString: String) {
        // Create a JSONObject and pass the json string
        val jsonObject = JSONObject(jsonString)
        val jsonArray = jsonObject.getJSONArray("records")
        println(jsonArray[0])
        println(jsonArray[1])
        //WIP

        for (spot in 0 until jsonArray.length()) {
            print(spot)
//            val id = spot.getString("id")
//            val destination = jsonObject.getString("Destination")
//            val geocode = jsonObject.getString("geocode")
//
//
//            // Use the extracted values and print them
//            println("id: $id")
//            println("destination: $destination")
//            println("geocode: $geocode")
        }
    }
}


