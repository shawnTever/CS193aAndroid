package com.example.cs193aandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TableRow
import kotlinx.android.synthetic.main.fragment_pokedex.*


class PokedexFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val detFrag = fragmentManager!!.findFragmentById(R.id.details_fragment) as DetailsFragment
//        0 until table_layout.childCount = 0 .. table_layout.childCount - 1
        for (i in 0 until table_layout.childCount) {
            val row = table_layout.getChildAt(i) as TableRow
            for (j in 0 .. row.childCount - 1) {
                val button = row.getChildAt(j) as ImageButton
                button.setOnClickListener{
                    
                }
            }
        }

    }

}