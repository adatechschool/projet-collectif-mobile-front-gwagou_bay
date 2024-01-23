package com.example.gwagou_bay.services

import com.example.gwagou_bay.SpotModel
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.IOException

class GetRequest {

    //function pour appel API qui retourne les datas au format json
    private fun makeGetRequest() {
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
        //.addHeader("Authorization", "Bearer patFMjbuBugC4G7A9.4454f5c043b6529a54444d7971322e5303cbb8747b789545274aef5665eb016b")
        //.addHeader("Cookie", "brw=brw2kYa4jmxqyLpd8; AWSALB=U26ouxw7j4ohFlExmNudgtGDG0bN6eC483Q2k5nSShiBWxRhFnxsw4NJi37lttLMGRR/b/As4XMsQuipbnIScu09XkTE1Fay8tDgCV8Z/vXJdwmb6gM3BYoOGDN4; AWSALBCORS=U26ouxw7j4ohFlExmNudgtGDG0bN6eC483Q2k5nSShiBWxRhFnxsw4NJi37lttLMGRR/b/As4XMsQuipbnIScu09XkTE1Fay8tDgCV8Z/vXJdwmb6gM3BYoOGDN4")


        // Execute the request and handle the response asynchronously
        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {
                // Handle failure
                println("Response failure.")
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                // Handle successful response

                val responseData = response.body.string() // get the response body and convert it to string

                runOnUiThread {
                    // Update UI or perform other tasks with the response data
                    parseJSON(responseData) // call the function to parse the data to an object in order to display it as a list
                }

                // Close the response body
                response.close()
            }
        })
    }
    // Create the function which can parse the
    fun parseJSON(jsonString: String) {
        // Create a JSONObject and pass the json string
        val jsonArray = JSONArray(jsonString)
        println(jsonArray[0])
        println(jsonArray.length())


        for (i in 0 until jsonArray.length()) { // to go through a json Array, for(... in ...) is not available; you have to use an iterator
            println(jsonArray[i])

            val spot = jsonArray.getJSONObject(i)  // extract the i element of the jsonArray, its type is jsonObject

//            val spotName = spot.getString("Name")
//            val spotCity = spot.get("City")
//            val spotGeocode = spot.get("Geocode")
//            val spotAddress = spot.get("Address")
//            val additionnalInformations = spot.get("Informations")
//            val wavesTypes = spot.get("WavesTypes")
//            val difficultyLevel = spot.get("DifficultyLevel")
//            val peakSurfSeasonStart = spot.get("PeakSurfSeasonStart")
//            val peakSurfSeasonEnd = spot.get("PeakSurfSeasonEnd")
//            val imageUrl = spot.get("ImageURL")
//            var liked = spot.get("Liked")

            println("juste avant initialisation du spotmodel")
            this.spotList.add(
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
        println(this.spotList)
    }
}