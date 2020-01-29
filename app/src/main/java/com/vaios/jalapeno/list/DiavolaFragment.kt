package com.vaios.jalapeno.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vaios.jalapeno.R
import kotlinx.android.synthetic.main.fragment_pizza_details.*

class DiavolaFragment : Fragment(R.layout.fragment_pizza_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        text_pizza_name.setText(R.string.pizza_diavola)
    }

}

