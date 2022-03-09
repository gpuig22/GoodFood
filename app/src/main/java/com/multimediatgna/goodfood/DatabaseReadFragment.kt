package com.multimediatgna.goodfood

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.multimediatgna.goodfood.ui.main.FirestoreDb

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

var mAuth: FirebaseAuth? = null
var currentUser: FirebaseUser? = null

/**
 * A simple [Fragment] subclass.
 * Use the [DatabaseReadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatabaseReadFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var mybutton: Button? = null
    private var mytextviewdate: TextView?= null
    private var mytextviewhour: TextView?= null
    var mydb: FirestoreDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myview = inflater.inflate(R.layout.fragment_database_read, container, false)
        mybutton = myview.findViewById<Button>(R.id.myfirestonebutton)
        mytextviewdate = myview.findViewById<TextView>(R.id.mydatetextview)
        mytextviewhour = myview.findViewById<TextView>(R.id.myhourtextview2)
        mybutton!!.setOnClickListener(this)
        mydb = FirestoreDb()
        mAuth = FirebaseAuth.getInstance()
        currentUser = mAuth!!.getCurrentUser()
        return myview

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DatabaseReadFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DatabaseReadFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(p0: View?) {

        val intent = requireActivity().intent
        mydb!!.getUltimoDiaConexion(intent.getStringExtra("myname").toString())
        mydb?.getUltimaHoraConexion(intent.getStringExtra("myname").toString())
        mytextviewdate!!.text = FirestoreDb.myfecha
        mytextviewhour!!.text = FirestoreDb.myhora

    }




}