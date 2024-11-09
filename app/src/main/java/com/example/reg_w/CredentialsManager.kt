package com.example.reg_w

class CredentialsManager {
    fun isEmailValid(email: String): Boolean {
        if (email.isEmpty()) {
            return false;
        }

        val emailRegex = "^[\\w]+@[\\w]+\\.[\\w]+$"

        return email.matches(emailRegex.toRegex());
    }

    fun isPasswordValid(password: String): Boolean {
        if (password.isEmpty()) {
            return false;
        }

        return true;
    }
}