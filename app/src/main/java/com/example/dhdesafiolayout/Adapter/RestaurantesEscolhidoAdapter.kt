package com.example.dhdesafiolayout.Adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.dhdesafiolayout.Model.RestauranteTela
import com.example.dhdesafiolayout.R


class RestaurantesEscolhidoAdapter(private val restauranteDado: MutableList<RestauranteTela>, var listener:OnClickRestauranteListener) :
    RecyclerView.Adapter<RestaurantesEscolhidoAdapter.RestauranteTelaViewHolder>() {

    inner class RestauranteTelaViewHolder(itemViewTela: View) : RecyclerView.ViewHolder(itemViewTela),
        View.OnClickListener {

        var fotoDoPrato: ImageView = itemViewTela.findViewById(R.id.pratoImage)
        var nomeDoPrato: TextView = itemViewTela.findViewById(R.id.nomeDoPrato)


        init {
            itemViewTela.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onClickRestaurante(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteTelaViewHolder {
        val itemViewtel = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_restaurantes_tela, parent, false)

        return RestauranteTelaViewHolder(itemViewtel)
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RestauranteTelaViewHolder, position: Int) {
        var restauranteTela = restauranteDado.get(position)

        holder.fotoDoPrato.clipToOutline = true
        holder.fotoDoPrato.setImageResource(restauranteTela.fotoDoPrato)
        holder.nomeDoPrato.text = restauranteTela.nomeDoPrato

    }

    override fun getItemCount() = restauranteDado.size

    interface OnClickRestauranteListener {
        fun onClickRestaurante(position: Int)

    }

}