package com.example.napoleonit

import java.io.Serializable

data class Product(
        val name: String,
        val price: Double,
        val discount: Int = 0) : Serializable {

    fun calcDiscountPrice(): Double {
        return price * (1 - (discount / 100.0))
    }
}

fun MutableList<Product>.sort(): MutableList<Product> {
    this.sortBy { it.name }
    return this
}