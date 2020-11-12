package com.example.dhdesafiolayout



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dhdesafiolayout.Adapter.RestaurantesEscolhidoAdapter
import com.example.dhdesafiolayout.Model.RestauranteTela
import kotlinx.android.synthetic.main.fragment_restaurante_tela.view.*


class RestauranteTelaFragment : Fragment(), RestaurantesEscolhidoAdapter.OnClickRestauranteListener {
    private var restauranteDados = getAllpratos()
    var adapter = RestaurantesEscolhidoAdapter(restauranteDados, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurante_tela, container, false)

        view.recyclerTelaRestaurante.adapter = adapter
        view.recyclerTelaRestaurante.layoutManager = LinearLayoutManager(activity)

        return view
    }
    private fun getAllpratos(): MutableList<RestauranteTela> {
        return mutableListOf<RestauranteTela>(
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            ),
            RestauranteTela(
                "Salada com molho Gengibre",
                R.drawable.ayoama
            )
        )
    }

    override fun onClickRestaurante(position: Int) {
        var restaurante = restauranteDados.get(position)
        adapter.notifyItemChanged(position)
        Toast.makeText(activity, restaurante.nomeDoPrato, Toast.LENGTH_SHORT).show()
    }

}






