package com.multimediatgna.goodfood.ui.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.handleCoroutineException

class FirestoreDb {

    val dbconnection = FirebaseFirestore.getInstance()

    companion object {
        var myfecha:String? = "Not Available"
    }

    fun saveDocument(
        p_correo: String,
        p_fecha: String
    ) {
        val user = hashMapOf("Email" to p_correo,"FechaLastLogin" to p_fecha)
        dbconnection.collection("users").document(p_correo)
            .set(user)
            .addOnSuccessListener { Log.d("GoodFood", "Collection <users> successfully written!") }
            .addOnFailureListener { e -> Log.w("GoodFood", "Error writing document", e) }
    }
    fun getUltimoDiaConexion (p_correo: String)  {
            dbconnection.collection("users").document(p_correo).get().addOnSuccessListener {task ->
                    myfecha=task.get("FechaLastLogin") as String?
                }
    }

}