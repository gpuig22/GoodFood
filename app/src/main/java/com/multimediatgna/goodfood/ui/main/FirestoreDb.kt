package com.multimediatgna.goodfood.ui.main

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

     var dbconnection = FirebaseFirestore.getInstance()

class FirestoreDb {

    companion object {
        var myfecha:String=""
        var myhora:String=""
    }


    fun saveDocument(
        p_correo: String,
        p_fecha: String,
        p_hora: String
    ) {
        dbconnection.collection("users").document(p_correo).set(
            hashMapOf(
                "Fecha" to p_fecha,
                "Hora" to p_hora
            )
        )
    }

    fun getUltimoDiaConexion (p_correo: String)  {


        var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        firestore.collection("users").document(p_correo)
            .get()
            .addOnSuccessListener {
                myfecha= it.get("Fecha") as String
            }
            .addOnFailureListener{
            }
    }

    fun getUltimaHoraConexion (p_correo: String) {
        var myhora:String=""
        var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        firestore.collection("users").document(p_correo)
            .get()
            .addOnSuccessListener {
                myhora= it.get("Hora") as String
            }
            .addOnFailureListener{

            }

    }



}