package com.example.reg_w

import org.junit.Test
import org.junit.Assert.*

class CredentialsManagerTest {
    @Test
    fun givenEmptyEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }

    @Test
    fun givenWrongEmail_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("not_correct.com")

        assertEquals(false, isEmailValid)
    }

    @Test
    fun givenProperEmail_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("username1@gmail.com")

        assertEquals(true, isEmailValid)
    }

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("")

        assertEquals(false, isPasswordValid)
    }

    @Test
    fun givenFilledPassword_thenReturnTrue() {
        val credentialsManager = CredentialsManager()

        val isPasswordValid = credentialsManager.isPasswordValid("password123")

        assertEquals(true, isPasswordValid)
    }

    @Test
    fun givenProperUnusedCredentials_whenUserRegister_thenSucceed() {
        val credentialsManager = CredentialsManager()
        val newEmail = "another@te.st"
        val newPassword = "1234qwer"
        credentialsManager.register("Full name", newEmail, "123456", newPassword)

        val isLoginSuccess = credentialsManager.login(newEmail, newPassword)
        assertTrue(isLoginSuccess)
    }
}