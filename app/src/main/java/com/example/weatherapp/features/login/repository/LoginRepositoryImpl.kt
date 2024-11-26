package com.example.weatherapp.features.login.repository
import com.example.weatherapp.data.firebase_firestore.MyFirebase
import kotlinx.coroutines.tasks.await

class LoginRepositoryImpl : LoginRepository {

    override suspend fun login(email: String, password: String) {
        MyFirebase.getInstance()
            .getAuth()
            .signInWithEmailAndPassword(email, password)
            .await()
    }
}