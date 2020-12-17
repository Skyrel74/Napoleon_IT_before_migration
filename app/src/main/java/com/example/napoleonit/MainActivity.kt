package com.example.napoleonit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.napoleonit.ui.CatalogFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        fragmentManager.beginTransaction()
                .add(R.id.container, CatalogFragment())
                .commit()
    }
}