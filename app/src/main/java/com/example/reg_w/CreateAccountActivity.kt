package com.example.reg_w

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val loginTextView: TextView = findViewById(R.id.loginText)

        loginTextView.setOnClickListener {
            val intent = Intent(this@CreateAccountActivity,  MainActivity::class.java)
            startActivity(intent)
        }
    }
}
