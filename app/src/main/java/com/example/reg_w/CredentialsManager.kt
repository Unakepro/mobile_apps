package com.example.reg_w

class CredentialsManager {
    var credentials = mutableMapOf<String, String>(
        Pair("test@te.st", "1234"),
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
        return credentials.containsKey(email)
    }
    fun isLoginPasswordValid(password: String): Boolean {
        return credentials.values.contains(password)
    }
    fun login(email: String, password: String): Boolean {
        return credentials[email].equals(password)
    }
    fun register(fullName: String, email: String, phone: String, password: String) {
        credentials.put(email, password)
    }

}