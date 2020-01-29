package com.vaios.jalapeno.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vaios.jalapeno.R
import kotlinx.android.synthetic.main.fragment_pizzas_list.*

class PizzaListFragment : Fragment(R.layout.fragment_pizzas_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PizzasAdapter()
        list_pizzas.adapter = adapter
    }

}
