package com.vaios.jalapeno.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vaios.jalapeno.R

class PizzaDetailsRouterFragment : Fragment() {

    companion object {
        private const val BUNDLE_KEY_PIZZA_TYPE = "pizzaType"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(arguments?.getSerializable(BUNDLE_KEY_PIZZA_TYPE) as PizzaType) {
            PizzaType.BBQ -> findNavController().navigate(R.id.fragment_bbq)
            PizzaType.DIAVOLA -> findNavController().navigate(R.id.fragment_diavola)
            PizzaType.PEPPERONI -> findNavController().navigate(R.id.fragment_pepperoni)
        }
    }

}
