package com.example.dhdesafiolayout.Fragment



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dhdesafiolayout.Adapter.RestaurantesEscolhidoAdapter
import com.example.dhdesafiolayout.Model.RestauranteTela
import com.example.dhdesafiolayout.R
import kotlinx.android.synthetic.main.fragment_restaurante_tela.view.*


class RestauranteTelaFragment : Fragment(), RestaurantesEscolhidoAdapter.OnClickRestauranteListener {
    private var restauranteDados = getAllpratos()
    var adaptertela = RestaurantesEscolhidoAdapter(restauranteDados, this)
    private  var foto : Int? = null
    private  lateinit var resTitulo: String


    override fun onCreate(savedInstanceState: Bundle?) {
        var mBundle =  Bundle();
        if(mBundle != null ) {
            mBundle = requireArguments();
            foto = mBundle.getInt("fotoRestaurante")
            resTitulo = mBundle.getString("tituloRestaurante")!!
        }


        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.hide()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurante_tela, container, false)

        view.imageView.setImageResource(foto!!)
        view.restauranteTitulo.text = resTitulo

        view.voltar.setOnClickListener {
            findNavController().navigate(R.id.action_restauranteTelaFragment_to_homeFragment)
        }

        view.recyclerTelaRestaurante.adapter = adaptertela
        view.recyclerTelaRestaurante.isNestedScrollingEnabled
        view.recyclerTelaRestaurante.layoutManager = GridLayoutManager(activity,2)

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

        val bundle = Bundle()
        bundle.putInt("fotoPrato", restaurante.fotoDoPrato)
        bundle.putString("nomePrato", restaurante.nomeDoPrato)
        arguments = bundle

        findNavController().navigate(R.id.action_restauranteTelaFragment_to_pratoDetalheFragment, bundle)

    }


    override fun onDestroy() {
        (activity as AppCompatActivity).supportActionBar?.show()

        super.onDestroy()
    }


}






