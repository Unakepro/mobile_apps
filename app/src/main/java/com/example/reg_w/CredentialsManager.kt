package com.example.reg_w

class CredentialsManager {
    val correctEmail = "test@te.st"
    val correctPassword = "1234"

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
    fun isLoginEmailValid(email: String): Boolean {
        return email == correctEmail
    }
    fun isLoginPasswordValid(password: String): Boolean {
        return password == correctPassword
    }

}