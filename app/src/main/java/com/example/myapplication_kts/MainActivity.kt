package com.example.myapplication_kts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentLogin())
                .commit()
        }
    }
    fun navigateToRegisterFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentRegister())
            .addToBackStack(null)
            .commit()
    }
    fun navigateToLoginFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentLogin())
            .addToBackStack(null)
            .commit()
    }
    fun navigateToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    fun navigateToRecipesList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, RecipesFragment())
            .addToBackStack(null) // Optional: Add to back stack if you want "back" navigation.
            .commit()
    }

    val recipesRecyclerView = findViewById<RecyclerView>(R.id.recipesList)
    recipesRecyclerView.adapter =
}

