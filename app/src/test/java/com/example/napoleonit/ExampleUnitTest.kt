package com.example.napoleonit

import org.junit.Test

import org.junit.Assert.*

class ExampleUnitTest {

    @Test
    fun sortCollection() {
        val products = mutableListOf(
            Product("a", 5.5),
            Product("c", 1.5),
            Product("b", 15.0)
        )

        val sortedProducts = mutableListOf(
            Product("a", 5.5),
            Product("b", 15.0),
            Product("c", 1.5)
        )

        assertEquals(products.sort(), sortedProducts)
    }
}

data class Product(
    val name: String,
    private val price: Double,
    private val discount: Int = 0)

fun MutableList<Product>.sort(): MutableList<Product> {
    this.sortBy { it.name }
    return this
}

