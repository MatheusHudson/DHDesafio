package com.example.dhdesafiolayout.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.dhdesafiolayout.R
import kotlinx.android.synthetic.main.detalhe_prato.view.*
import kotlinx.android.synthetic.main.fragment_restaurante_tela.view.*
import kotlinx.android.synthetic.main.fragment_restaurante_tela.view.imageView

class PratoDetalheFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_prato_detalhe, container, false)
        var mBundle =  Bundle();
        if(mBundle != null) {
            mBundle = requireArguments();
            var foto = mBundle.getInt("fotoPrato")
            var nomePrato = mBundle.getString("nomePrato")

            view.fotoPrato.setImageResource(foto)
            view.tituloPrato.text = nomePrato
        }
        view.voltarTelaPrato.setOnClickListener {
           (activity as AppCompatActivity).onBackPressed()

        }
        return view
    }



}