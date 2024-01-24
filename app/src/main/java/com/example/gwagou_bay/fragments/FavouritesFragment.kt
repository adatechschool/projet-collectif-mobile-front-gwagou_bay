package com.example.gwagou_bay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gwagou_bay.MainActivity
import com.example.gwagou_bay.R
import com.example.gwagou_bay.SpotModel
import com.example.gwagou_bay.adapter.SpotAdapter

// pour l'autocomplétion taper: oncreateview -> cliquer sur overide fun...
class FavouritesFragment (private val context : MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {



        //créer une liste qui va stocker les spots
        val spotList = arrayListOf<SpotModel>()


        spotList.add(SpotModel(
            "Kitty Hawk",
            "Kitty Hawk",
            "U2tlbGV0b24gQmF5LCBOYW1pYmlhIiwibyI6eyJzdGF0dXMiOiJPSyIsImZvcm1hdHRlZEFkZHJlc3MiOiJOYW1pYmlhIiwibGF0IjotMjUuOTE0NDkxOSwibG5nIjoxNC45MDY4NTk...",
            "Kitty Hawk, North Carolina",
            "dogs allowed",
            "Outer Banks",
            "3",
            "august",
            "october",
            "https://spot-thumbnails.cdn-surfline.com/spots/5842041f4e65fad6a7708863/5842041f4e65fad6a7708863_1500.jpg",
            true
        ))

        spotList.add(SpotModel())

        //println(spotList)

        // inflate injecte le layout du fragment    -    le ? permet d'afficher même si il n'y a pas de fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //récupérer le recyclerview
        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView?.adapter = SpotAdapter(context, spotList, R.layout.item_vertical_popular_spot)
        return view
    }
}