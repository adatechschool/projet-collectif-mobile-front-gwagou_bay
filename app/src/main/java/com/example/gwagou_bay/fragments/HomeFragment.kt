package com.example.gwagou_bay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gwagou_bay.R

// pour l'autocomplétion taper: oncreateview -> cliquer sur overide fun...
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate injecte le layout du fragment    -    le ? permet d'afficher même si il n'y a pas de fragment
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }
}