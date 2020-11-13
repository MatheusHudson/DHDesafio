package com.example.dhdesafiolayout.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhdesafiolayout.Adapter.RestaurantesAdapter
import com.example.dhdesafiolayout.Model.Restaurante
import com.example.dhdesafiolayout.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(), RestaurantesAdapter.OnClickRestauranteListener {
    private var listaRestaurante = getAllRestaurantes()
    var adapter = RestaurantesAdapter(listaRestaurante, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.recyclerRestaurantes.adapter = adapter
        view.recyclerRestaurantes.layoutManager = LinearLayoutManager(activity)



        return view
    }

    private fun getAllRestaurantes(): MutableList<Restaurante> {
        return mutableListOf<Restaurante>(
            Restaurante(
                R.drawable.tony,
                "Tony Roma's",
                "Av. Lavandisca, 717 - Indianópolis, São Paulo",
                "Fecha às 22:00"
            ),
            Restaurante(
                R.drawable.ayoama,
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00"
            ),
            Restaurante(
                R.drawable.outback,
                "Outback - Moema",
                "Av. Moaci, 187, 187 - Moema, São Paulo",
                "Fecha às 00:00"
            ),
            Restaurante(
                R.drawable.sisenor,
                "Sí Señor!",
                "Alameda Jauaperi, 625 - Moema",
                "Fecha às 01:00"
            )
        )
    }

    override fun onClickRestaurante(position: Int) {
        var restaurante = listaRestaurante.get(position)

        when (restaurante.titulo) {
            "Tony Roma's" -> {
                val bundle = Bundle()
                bundle.putInt("fotoRestaurante", restaurante.foto)
                bundle.putString("tituloRestaurante", restaurante.titulo)
                arguments = bundle

                findNavController().navigate(R.id.action_homeFragment_to_restauranteTelaFragment, bundle)
            }
        }
    }

}