package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_adapters.*
import java.util.*
import kotlin.collections.ArrayList

class ListAdapters : AppCompatActivity() {
    private val defns = ArrayList<String> ()
//    private var myAdapter : ArrayAdapter<String>? = null
    private lateinit var myAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapters)

        val list = ArrayList<String>()
        list.add("Hello")
        list.add("Goodbye")
        list.add("Marty")

        val rand = Random()
        val index = rand.nextInt(list.size)
        val word = list[index]

        the_word.text = word

//        pick random definitions for the word
//        val defns = ArrayList<String>()
        defns.add("a greeting")
        defns.add("sth you say when you are done talking")
        defns.add("a dude")
        defns.add("another name for a duck")
        defns.add("the President")
        defns.add("nothing at all")

        defns.shuffle()

        val myAdapter = ArrayAdapter<String> (this,
            android.R.layout.simple_expandable_list_item_1, defns)
//        for (defn in defns.subList(0, 4)) {
//
//        }
        definitions_list.adapter = myAdapter

        definitions_list.setOnItemClickListener {_, _, index, _ ->
            defns.removeAt(index)
            myAdapter.notifyDataSetChanged()
        }

    }
}