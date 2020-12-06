package com.example.napoleonit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity: AppCompatActivity() {

    private val PRODUCT_TAG = "PRODUCT_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        var currentProduct = intent?.extras?.getSerializable(PRODUCT_TAG) as Product

        nameEt.setText(currentProduct.name)
        priceEt.setText(currentProduct.price.toString())
        discountEt.setText(currentProduct.discount.toString())

        changeBtn.setOnClickListener {
            currentProduct = Product(nameEt.text.toString(),
                    priceEt.text.toString().toDouble(),
                    discountEt.text.toString().toInt())
        }

        returnBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(PRODUCT_TAG, currentProduct)
            startActivity(intent)
        }
    }
}