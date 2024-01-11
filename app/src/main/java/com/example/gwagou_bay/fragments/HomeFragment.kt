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
class HomeFragment (private val context : MainActivity) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //créer une liste qui va stocker les spots
        val spotList = arrayListOf<SpotModel>()

        //enregistrer un premier spot dans notre liste (Pipeline)
        spotList.add(SpotModel(
            "Skeleton bay",
            "Skeleton bay",
            "eyJpIjoiU2tlbGV0b24gQmF5LCBOYW1pYmlhIiwibyI6eyJzdGF0dXMiOiJPSyIsImZvcm1hdHRlZEFkZHJlc3MiOiJOYW1pYmlhIiwibGF0IjotMjUuOTE0NDkxOSwibG5nIjoxNC45MDY4NTk...",
            "Skeleton bay, Namibia",
            "dogs allowed",
            "Point break",
            "5",
            "september",
            "december",
            "https://cdn.pixabay.com/photo/2020/09/01/08/32/ocean-5534609_1280.jpg",
            false
        ))

        // 2ieme spot pour test
        spotList.add(SpotModel())

        println(spotList)

        // inflate injecte le layout du fragment    -    le ? permet d'afficher même si il n'y a pas de fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //récupérer le recyclerview
        val verticalRecyclerView = view?.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView?.adapter = SpotAdapter(context, spotList, R.layout.item_vertical_popular_spot)
        return view
    }
}