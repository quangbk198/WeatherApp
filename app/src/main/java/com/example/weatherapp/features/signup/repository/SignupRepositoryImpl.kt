package com.example.weatherapp.features.signup.repository

import com.example.weatherapp.data.firebase_firestore.MyFirebase
import kotlinx.coroutines.tasks.await

class SignupRepositoryImpl : SignupRepository {

    override suspend fun signup(repass: String, password: String, email: String, phone: Long) {
        // Registor with Firebase Authentication
        val result = MyFirebase.getInstance()
            .getAuth()
            .createUserWithEmailAndPassword(email, password)
            .await()

        // Get new userID
        val uid = result.user?.uid ?: throw IllegalStateException("Create accout fail.")

        // Store user info to firebase store
        val userData = mapOf(
            "uid" to uid,
            "email" to email,
            "phone" to phone
        )
        MyFirebase.getInstance()
            .getFirestore()
            .collection("users")
            .document(uid)
            .set(userData)
            .await()

    }
}
