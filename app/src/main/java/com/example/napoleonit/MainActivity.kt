package com.example.napoleonit

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val PRODUCT_TAG = "PRODUCT_TAG"
    private var currentProduct = Product("Мяч", 800.0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentObjectFields.text = "Имя:${currentProduct.name} Цена:${currentProduct.calcDiscountPrice()}"

        editBtn.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra(PRODUCT_TAG, currentProduct)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val changedProduct = intent?.extras?.getSerializable(PRODUCT_TAG)
        if (changedProduct != null) {
            currentProduct = changedProduct as Product
            currentObjectFields.text = "Имя:${currentProduct.name} Цена:${currentProduct.calcDiscountPrice()}"
        }
    }
}