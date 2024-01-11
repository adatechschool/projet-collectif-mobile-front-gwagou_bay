package com.example.gwagou_bay.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gwagou_bay.MainActivity
import com.example.gwagou_bay.R
import com.example.gwagou_bay.SpotModel

class SpotAdapter (
    private val context : MainActivity,
    private val spotList : List<SpotModel>, // récupére la liste des spots qui ont été créer dans le fichier dans HomeFragment.kt
    private val layoutId: Int): RecyclerView.Adapter<SpotAdapter.ViewHolder>(){

    // Boite pour ranger tous les composants à contrôler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        // Image du spot
        val spotImage = view.findViewById<ImageView>(R.id.spot_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = spotList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // récupérer les information du spot
        val currentSpot = spotList[position]

        //utilise Glide pour récupérer l'image à partir de son url pour avoir l'affichage sur le composant
        Glide.with(context).load(Uri.parse(currentSpot.imageUrl)).into(holder.spotImage) // pour mettre le contexte (base de données interne qui contient toutes les infos contextuelles de l'app comme le num de version, les infos spécifique de l'activité)
    }


}