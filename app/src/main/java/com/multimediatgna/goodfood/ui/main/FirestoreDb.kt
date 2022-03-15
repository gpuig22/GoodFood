package com.multimediatgna.goodfood.ui.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


class FirestoreDb {

    companion object {
        var myfecha:String? = "Not Available"
    }

    fun saveDocument(
        p_correo: String,
        p_fecha: String
    ) {

        val myuser = hashMapOf<String,Any>("FechaLastLogin" to p_fecha)
        val dbconnection = FirebaseFirestore.getInstance()
        dbconnection.collection("users").document(p_correo)
            .set(myuser)
            .addOnSuccessListener { Log.d("GoodFood", "Collection users document " + p_correo + " successfully written!") }
            .addOnFailureListener { e -> Log.w("GoodFood", "Error writing collection users document " + p_correo, e) }
    }
    fun getUltimoDiaConexion (p_correo: String)  {

        val dbconnection = FirebaseFirestore.getInstance()
        Log.d("GoodFood","dbconnection: " + dbconnection.toString())
            dbconnection.collection("users").document(p_correo).get().addOnSuccessListener {task ->
                    myfecha=task.get("FechaLastLogin") as String?
                }
    }

}