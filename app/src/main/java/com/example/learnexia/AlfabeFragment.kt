package com.example.learnexia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.GridView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlfabeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlfabeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_alfabe, container, false)

        var alpha = Array(size = 26) {""}//26 harf tanımlandı
        var count = 65 // 65 büyük a "A" nın ASCII karşılığı.Böylece A'dan başlayarak A,B,C.. şeklinde gidecek
        for(i in alpha.indices)//sıfırdan 25'e kadar loop
            {
            alpha[i] = Character.toString(count.toChar()) //ASCII olarak A yazdırıp duracak, bunu engellemek için count++

            count++
        }

        var adapter = ArrayAdapter(v.context, android.R.layout.simple_dropdown_item_1line, alpha)
        var gv = v.findViewById<GridView>(R.id.gridview1)
        gv.adapter = adapter

        gv.setOnItemClickListener{parent, view, position, id ->
            var intent = Intent(v.context, Alfabe_Detay_Aktivite::class.java)
            intent.putExtra("alpha", alpha[position])
            startActivity(intent)
        }


        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlfabeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlfabeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}