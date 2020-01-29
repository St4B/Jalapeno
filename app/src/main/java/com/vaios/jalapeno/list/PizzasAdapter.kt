package com.vaios.jalapeno.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.vaios.jalapeno.R
import kotlinx.android.synthetic.main.fragment_pizza_details.view.*

class PizzasAdapter : RecyclerView.Adapter<PizzasAdapter.PizzaViewHolder>() {

    private val pizzas = listOf(PizzaType.BBQ, PizzaType.DIAVOLA, PizzaType.PEPPERONI)

    class PizzaViewHolder(layout :ConstraintLayout): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_pizza, parent, false) as ConstraintLayout

        return PizzaViewHolder(card)
    }

    override fun getItemCount(): Int = pizzas.size

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val context = holder.itemView.context
        val name = when(pizzas[position]) {
            PizzaType.BBQ -> context.getString(R.string.pizza_bbq)
            PizzaType.DIAVOLA -> context.getString(R.string.pizza_diavola)
            PizzaType.PEPPERONI -> context.getString(R.string.pizza_pepperoni)
        }
        holder.itemView.text_pizza_name.text = name
    }

}
