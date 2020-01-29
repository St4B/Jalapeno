package com.vaios.jalapeno.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vaios.jalapeno.R
import com.vaios.jalapeno.list.PizzaDetailsRouterFragment
import com.vaios.jalapeno.list.PizzaType
import kotlinx.android.synthetic.main.fragment_favorite_pizza.*

class MyFavoritePizzaFragment : Fragment(R.layout.fragment_favorite_pizza) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_favorite_pizza.setOnClickListener {
            val args = Bundle()
            args.putSerializable(
                PizzaDetailsRouterFragment.BUNDLE_KEY_PIZZA_TYPE,
                PizzaType.DIAVOLA
            )
            findNavController().navigate(R.id.go_to_details, args)
        }
    }
}
