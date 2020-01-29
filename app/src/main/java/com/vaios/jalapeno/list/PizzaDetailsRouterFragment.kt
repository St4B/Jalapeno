package com.vaios.jalapeno.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.vaios.jalapeno.R

class PizzaDetailsRouterFragment : Fragment() {

    companion object {
        const val BUNDLE_KEY_PIZZA_TYPE = "pizzaType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navOptions =
            NavOptions.Builder().setPopUpTo(R.id.fragment_details_router, true).build()

        when(arguments?.getSerializable(BUNDLE_KEY_PIZZA_TYPE) as PizzaType) {
            PizzaType.BBQ -> findNavController().navigate(R.id.fragment_bbq, null, navOptions)
            PizzaType.DIAVOLA -> findNavController().navigate(R.id.fragment_diavola, null, navOptions)
            PizzaType.PEPPERONI -> findNavController().navigate(R.id.fragment_pepperoni, null, navOptions)
        }
    }

}
