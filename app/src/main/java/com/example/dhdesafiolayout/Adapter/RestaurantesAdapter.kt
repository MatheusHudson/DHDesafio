package com.example.dhdesafiolayout.Adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.dhdesafiolayout.Model.Restaurante
import com.example.dhdesafiolayout.R

class RestaurantesAdapter(private val listaRestaurantes: MutableList<Restaurante>, var listener:OnClickRestauranteListener) :
    RecyclerView.Adapter<RestaurantesAdapter.RestauranteViewHolder>() {

    inner class RestauranteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var fotoRestaurante: ImageView = itemView.findViewById(R.id.imageRestaurante)
        var tituloRestaurante: TextView = itemView.findViewById(R.id.tituloRestaurante)
        var enderecoRestaurante: TextView = itemView.findViewById(R.id.enderecoRestaurante)
        var horarioRestaurante: TextView = itemView.findViewById(R.id.horarioRestaurante)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onClickRestaurante(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_restaurantes, parent, false)

        return RestauranteViewHolder(itemView)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        var restaurante = listaRestaurantes.get(position)

        holder.fotoRestaurante.clipToOutline = true
        holder.fotoRestaurante.setImageResource(restaurante.foto)

        holder.tituloRestaurante.text = restaurante.titulo
        holder.enderecoRestaurante.text = restaurante.endereco
        holder.horarioRestaurante.text = restaurante.horario
    }

    override fun getItemCount() = listaRestaurantes.size

    interface OnClickRestauranteListener {
        fun onClickRestaurante(position: Int)
    }
}