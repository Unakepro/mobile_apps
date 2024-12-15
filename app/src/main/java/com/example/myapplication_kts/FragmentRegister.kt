package com.example.myapplication_kts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class FragmentRegister : Fragment(R.layout.fragment_register) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val credentialsManager = CredentialsManager()

        val loginTextView = view.findViewById<TextView>(R.id.loginText)

        val registerButton = view.findViewById<Button>(R.id.signUpButton)

        val editMailContent = view.findViewById<TextInputEditText>(R.id.editEmailContent)

        val editMailLayout = view.findViewById<TextInputLayout>(R.id.editEmail)

        loginTextView.setOnClickListener {
            (activity as MainActivity).navigateToLoginFragment()
        }
        registerButton.setOnClickListener {
            val email = editMailContent.text.toString()

            var isValid = true
            if (!credentialsManager.isEmailValid(email)) {
                editMailLayout.error = "Invalid email format"
                isValid = false
            } else if (!credentialsManager.isLoginEmailValid(email)) {
                editMailLayout.error = "Email is already taken"
                isValid = false
            } else {
                editMailLayout.isErrorEnabled = false
            }
            if (isValid) {
                parentFragmentManager.popBackStack()
            }
        }
    }
}
