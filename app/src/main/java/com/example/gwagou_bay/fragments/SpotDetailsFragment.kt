package com.example.gwagou_bay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gwagou_bay.MainActivity
import com.example.gwagou_bay.R

class SpotDetailsFragment(
    private val context: MainActivity
) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //permet d'injecter le layout associé
        val view = inflater?.inflate(R.layout.spot_details, container, false)

        return view
    }
}