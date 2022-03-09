package com.multimediatgna.goodfood.ui.main

import com.google.firebase.firestore.FirebaseFirestore

     var dbconnection = FirebaseFirestore.getInstance()

class FirestoreDb {
    fun `saveDocument$GoodFood_app`(
        p_correo: String,
        p_model_value: String,
        p_manufacturer_value: String
    ) {
        dbconnection.collection("users").document(p_correo).set(
            hashMapOf(
                "ModeloTelefono" to p_model_value,
                "Manufacturer" to p_manufacturer_value
            )
        )
    }
}