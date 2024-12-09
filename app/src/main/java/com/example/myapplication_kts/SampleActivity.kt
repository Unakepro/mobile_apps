package com.example.myapplication_kts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import android.widget.Button
import androidx.fragment.app.commit


class SampleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.sample_activity)


        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, FragmentA())
            }
        }
        val toggleButton: Button = findViewById(R.id.switch_button)
        toggleButton.setOnClickListener {
            toggleFragments()
        }

    }

    private fun toggleFragments() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment is FragmentA) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, FragmentB())
                addToBackStack(null)
            }
        } else if (currentFragment is FragmentB) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, FragmentA())
                addToBackStack(null)
            }
        }
    }
}