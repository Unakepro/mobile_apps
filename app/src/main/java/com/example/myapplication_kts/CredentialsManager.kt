package com.example.myapplication_kts

object CredentialsManager {
    var credentials = mutableMapOf<String, String>(
        "test@te.st" to "1234",
        "test2@te.st" to "1234"
    )

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
        return credentials.keys.any { it.equals(email, ignoreCase = true) }
    }

    fun isLoginPasswordValid(password: String): Boolean {
        return credentials.values.contains(password)
    }

    fun login(email: String, password: String): Boolean {
        return credentials[email].equals(password)
    }

    fun register(email: String, password: String) {
        if(!isLoginEmailValid(email)) credentials[email] = password
    }

}