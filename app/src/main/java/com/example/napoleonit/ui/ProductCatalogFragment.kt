package com.example.napoleonit.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.napoleonit.R
import kotlinx.android.synthetic.main.fragment_product_catalog.*

class ProductCatalogFragment : Fragment(R.layout.fragment_product_catalog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailedBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                    .replace(R.id.container, ProductDetailsFragment())
                    .addToBackStack("Catalog")
                    .commit()
        }

        cartBtn.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, CartFragment())
                .addToBackStack("Checkout")
                .commit()
        }
    }
}