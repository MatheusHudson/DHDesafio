package com.example.dhdesafiolayout.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dhdesafiolayout.R
import kotlinx.android.synthetic.main.cadastro_layout.view.*

class cadastroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cadastro, container, false)

        view.button.setOnClickListener {
            findNavController().navigate(R.id.action_cadastroFragment_to_homeFragment)
        }

        return  view
    }

}