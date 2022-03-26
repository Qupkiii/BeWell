package com.example.bewell.Database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.sql.Timestamp
import kotlin.Exception

abstract class DataHandler {
    protected val outerCollection: String = "Users"

    protected val uid = FirebaseAuth.getInstance().currentUser?.uid
    protected val db = Firebase.firestore

    fun userDataUpload(data: HashMap<String, Any>) {
//        val data = hashMapOf(
//            "fName" to fName,
//            "lName" to lName,
//            "dateOfBirth" to dateOfBirth,
//            "conditionScore" to score,
//            "doctorEmail" to doctorEmail,
//            "contactEmail" to contactEmails,
//            "dateOfRegistration" to dateOfRegistration
//        )
        db.collection(outerCollection).document(uid.toString()).set(data)
            .addOnFailureListener { e ->
                throw Exception("Upload failed (userDataUpload): ${e.message}")
            }
    }

    abstract fun uploadToFirebase()



}