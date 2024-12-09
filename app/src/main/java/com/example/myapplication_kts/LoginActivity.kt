package com.example.myapplication_kts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.example.myapplication_kts.MainActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginActivity : AppCompatActivity() {
    val credentialsManager = CredentialsManager()
    val editMailLayout: TextInputLayout
        get() = findViewById(R.id.editMail)

    val editPasswordLayout : TextInputLayout
        get() = findViewById<TextInputLayout>(R.id.editPassword)

    val editMailContent: TextInputEditText
        get() = findViewById(R.id.editMailContent)

    val submitButton: Button
        get() = findViewById(R.id.signInButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerNowTextView: TextView = findViewById(R.id.registerNowText)

        registerNowTextView.setOnClickListener {
            val intent = Intent(this@LoginActivity, CreateAccountActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        submitButton.setOnClickListener {
            val email = editMailContent.text.toString()
            val password = findViewById<TextInputEditText>(R.id.editPasswordContent).text.toString()

            var isValid = true

            if (!credentialsManager.isEmailValid(email)) {
                editMailLayout.error = "Invalid email format"
                isValid = false
            } else if (!credentialsManager.isLoginEmailValid(email)) {
                editMailLayout.error = "Invalid email"
                isValid = false
            } else{
                editMailLayout.isErrorEnabled = false
            }

            if (password.isEmpty()) {
                editPasswordLayout.error = "Password cannot be empty"
                isValid = false
            } else if (!credentialsManager.isLoginPasswordValid(password)) {
                editPasswordLayout.error = "Invalid password"
                isValid = false
            } else{
                editPasswordLayout.isErrorEnabled = false
            }

            if(isValid){
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }

        }
    }
}
