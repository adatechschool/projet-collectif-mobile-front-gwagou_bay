package com.example.gwagou_bay.services

import com.example.gwagou_bay.SpotModel
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.IOException

class SpotListService : Callback {
    private var spotList: ArrayList<SpotModel> ?= null
    private var onRequestCompleteListener : OnRequestCompleteListener? =null

    //function pour appel API qui retourne les datas au format json
    public fun getSpotList() {
        // Create an OkHttpClient instance
        val client = OkHttpClient()  // méthode qui renvoie une requête http

        // Replace the URL with the desired endpoint
        // ancienne url pour l'api airtable :
        // val url = "https://api.airtable.com/v0/apptEhqmwsc6jfuFF/Surf%20Destinations"
        val url = "http://10.0.2.2:8080/spots"

        // Create a request using the GET method
        val request = Request.Builder()
            .url(url)
            .get()
            .build()

        // Execute the request and handle the response asynchronously
        client.newCall(request).enqueue(this)

    }




    override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
        // Handle successful response
        val responseData = response.body.string() // get the response body and convert it to string

        //runOnUiThread {
        // Update UI or perform other tasks with the response data
        this.spotList = parseJSON(responseData) // call the function to parse the data to an object in order to display it as a list
        //}
        // Close the response body
        response.close()
    }

    override fun onFailure(call : Call, e:IOException) {
        println("error")
    }


    // Create the function which can parse the
    fun parseJSON(jsonString: String) : ArrayList<SpotModel> {
        // Create a JSONObject and pass the json string
        val jsonArray = JSONArray(jsonString)
        println(jsonArray[0])
        println(jsonArray.length())

        var spotList = arrayListOf<SpotModel>()

        for (i in 0 until jsonArray.length()) { // to go through a json Array, for(... in ...) is not available; you have to use an iterator
            println(jsonArray[i])

            val spot = jsonArray.getJSONObject(i)  // extract the i element of the jsonArray, its type is jsonObject


            println("juste avant initialisation du spotmodel")

            spotList.add(
                SpotModel(
                spot.getString("Name"),
                spot.getString("City"),
                spot.getString("Geocode"),
                spot.getString("Address"),
                spot.getString("Informations"),
                spot.getString("WavesTypes"),
                spot.getString("DifficultyLevel"),
                spot.getString("PeakSurfSeasonStart"),
                spot.getString("PeakSurfSeasonEnd"),
                spot.getString("ImageURL"),
                spot.getBoolean("Liked")
            )
            )

        }
        println(spotList)
        return spotList
    }
}

interface OnRequestCompleteListener{
    fun onSuccess(spotList: ArrayList<SpotModel>)
    fun onError()
}