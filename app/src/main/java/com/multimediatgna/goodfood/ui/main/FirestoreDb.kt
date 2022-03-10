package com.multimediatgna.goodfood.ui.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore


class FirestoreDb {

    val dbconnection = FirebaseFirestore.getInstance()
    companion object {
        var myfecha:String=""
        var myhora:String=""
    }

    fun saveDocument(
        p_correo: String,
        p_fecha: String
    ) {

        dbconnection.collection("users").document(p_correo).set(
            hashMapOf(
                "Fecha" to p_fecha
            )
        )
    }

    fun getUltimoDiaConexion (p_correo: String)  {

        dbconnection.collection("users").document(p_correo)
            .get()
            .addOnSuccessListener {
                myfecha= it.get("Fecha") as String
            }
            .addOnFailureListener{
            }
    }





}