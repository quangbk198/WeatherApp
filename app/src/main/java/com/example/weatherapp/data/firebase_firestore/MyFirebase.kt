package com.example.weatherapp.data.firebase_firestore

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MyFirebase {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    companion object {
        private var INSTANCE: MyFirebase? = null

        fun getInstance(): MyFirebase {
            if (INSTANCE == null) {
                INSTANCE = MyFirebase()
            }
            return INSTANCE!!
        }
    }

    fun getFirestore(): FirebaseFirestore {
        return firestore
    }

    fun getAuth(): FirebaseAuth {
        return auth
    }
}