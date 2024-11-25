package com.example.weatherapp.features.signup.repository

import com.example.weatherapp.data.firebase_firestore.MyFirebase
import kotlinx.coroutines.tasks.await

class SignupRepositoryImpl : SignupRepository {

    override suspend fun signup(username: String, password: String, email: String, phone: Long) {
        // Registor with Firebase Authentication
        val result = MyFirebase.getInstance()
            .getAuth()
            .createUserWithEmailAndPassword(email, password)
            .await()

        // Lấy UID của người dùng mới
        val uid = result.user?.uid ?: throw IllegalStateException("Create accout fail.")

        // Lưu thêm thông tin người dùng vào Firestore
        val userData = mapOf(
            "uid" to uid,
            "username" to username,
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
