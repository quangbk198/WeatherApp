package com.example.weatherapp.features.login.repository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay


class LoginRepositoryImpl : LoginRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    override suspend fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
        delay(3000)
        throw NullPointerException()
    }
}