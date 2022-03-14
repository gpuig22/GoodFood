package com.multimediatgna.goodfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.multimediatgna.goodfood.ui.main.FirestoreDb
import com.multimediatgna.goodfood.ui.main.MainViewModel
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [DatabaseReadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatabaseReadFragment : Fragment(), View.OnClickListener {

    var mAuth: FirebaseAuth? = null
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mybutton: Button
    private var mytextviewdate: TextView?= null
    private var myusername: TextView?= null
    var mydb: FirestoreDb? = null
    private var mViewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        mydb = FirestoreDb()
        mAuth = FirebaseAuth.getInstance()
        mViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myview = inflater.inflate(R.layout.fragment_database_read, container, false)
        mytextviewdate = myview.findViewById<TextView>(R.id.mylastconnectiontextview)
        mybutton = myview.findViewById<Button>(R.id.mybuttonclosesession)
        mybutton.setOnClickListener(this)
        myusername =myview.findViewById<TextView>(R.id.myusertextview2)
        myusername?.setText(mViewModel!!.mycurrentuser)
        mydb!!.getUltimoDiaConexion(mViewModel!!.mycurrentuser)
        mytextviewdate!!.text = FirestoreDb.myfecha
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

        mydb = FirestoreDb()
        val formateador = SimpleDateFormat(
            "dd 'de' MMMM 'de' yyyy '-' hh:MM:ss", Locale("es_ES")
        )
        val fechaDate = Date()
        val fecha = formateador.format(fechaDate)
        mydb!!.saveDocument(mViewModel!!.mycurrentuser, (if (fecha != null) fecha else null)!!)

        FirebaseAuth.getInstance().signOut();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

    }




}