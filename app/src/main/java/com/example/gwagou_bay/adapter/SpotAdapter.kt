package com.example.gwagou_bay.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gwagou_bay.MainActivity
import com.example.gwagou_bay.R
import com.example.gwagou_bay.SpotModel

class SpotAdapter (
    private val context : MainActivity,
    private val spotList : List<SpotModel>, // récupére la liste des spots qui ont été créer dans le fichier dans HomeFragment.kt
    private val layoutId: Int
): RecyclerView.Adapter<SpotAdapter.ViewHolder>(){

    // Boite pour ranger tous les composants à contrôler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        // Image du spot
        val spotImage = view.findViewById<ImageView>(R.id.spot_view)
        val spotName:TextView? = view.findViewById(R.id.spot_name_item)
        val cityName:TextView? = view.findViewById(R.id.spot_city_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(layoutId, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = spotList.size

    // Fonction qui affiche les informations et l'image à partir de la liste des spots
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // récupérer les information du spot
        val currentSpot = spotList[position]

        //utilise Glide pour récupérer l'image à partir de son url pour avoir l'affichage sur le composant
        Glide.with(context).load(Uri.parse(currentSpot.imageUrl)).into(holder.spotImage) // pour mettre le contexte (base de données interne qui contient toutes les infos contextuelles de l'app comme le num de version, les infos spécifique de l'activité)

        // mettre à jour le nom du spot
        holder.spotName?.text = currentSpot.spotName

        // mettre à jour le nom de la ville du spot
        holder.cityName?.text = currentSpot.spotCity

    }


}