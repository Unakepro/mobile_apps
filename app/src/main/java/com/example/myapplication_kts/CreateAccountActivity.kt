package com.example.myapplication_kts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CreateAccountActivity : AppCompatActivity() {
    val credentialsManager = CredentialsManager()

    val loginTextView: TextView
        get() = findViewById(R.id.loginText)

    val registerButton: Button
        get() = findViewById(R.id.signUpButton)

    val editMailContent: TextInputEditText
        get() = findViewById(R.id.editEmailContent)

    val editMailLayout: TextInputLayout
        get() = findViewById(R.id.editEmail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        loginTextView.setOnClickListener {
            val intent = Intent(this@CreateAccountActivity,  LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        registerButton.setOnClickListener {
            val email = editMailContent.text.toString()

            var isValid = true
            if (!credentialsManager.isEmailValid(email)) {
                editMailLayout.error = "Invalid email format"
                isValid = false
            }
            else if (!credentialsManager.isLoginEmailValid(email)) {
                editMailLayout.error = "Email is already taken"
                isValid = false
            }
            else {
                editMailLayout.isErrorEnabled = false
            }

            if(isValid){
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }

    }
}
