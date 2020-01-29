package com.vaios.jalapeno.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vaios.jalapeno.R
import com.vaios.jalapeno.list.PizzaDetailsRouterFragment.Companion.BUNDLE_KEY_PIZZA_TYPE
import kotlinx.android.synthetic.main.fragment_pizzas_list.*

class PizzaListFragment : Fragment(R.layout.fragment_pizzas_list) {

    private val clickAction: (PizzaType) -> Unit = {
        val args = Bundle()
        args.putSerializable(BUNDLE_KEY_PIZZA_TYPE, it)
        findNavController().navigate(R.id.go_to_details, args)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PizzasAdapter()
        adapter.onClick = clickAction
        list_pizzas.adapter = adapter
    }

}
