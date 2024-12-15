package com.example.myapplication_kts

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class FragmentLogin : Fragment(R.layout.fragment_login){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val credentialsManager = CredentialsManager
        val editMailLayout = view.findViewById<TextInputLayout>(R.id.editMail)

        val editPasswordLayout = view.findViewById<TextInputLayout>(R.id.editPassword)

        val editMailContent = view.findViewById<TextInputEditText>(R.id.editMailContent)

        val submitButton = view.findViewById<Button>(R.id.signInButton)

        val registerNowTextView = view.findViewById<TextView>(R.id.registerNowText)

        registerNowTextView.setOnClickListener {
            (activity as MainActivity).navigateToRegisterFragment()
        }

        submitButton.setOnClickListener {
            val email = editMailContent.text.toString()
            val password = view.findViewById<TextInputEditText>(R.id.editPasswordContent).text.toString()

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
                (activity as MainActivity).navigateToMainScreen()
            }

        }
    }
}
