package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_adapters.*
import java.io.BufferedReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ListAdapters : AppCompatActivity() {
    private var wordToDefn = HashMap<String, String>()
    private val words = ArrayList<String> ()
    private val defns = ArrayList<String> ()
//    private var myAdapter : ArrayAdapter<String>? = null
    private lateinit var myAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapters)

////        create a list
//        val list = ArrayList<String>()
//        list.add("Hello")
//        list.add("Goodbye")
//        list.add("Marty")
//
//        val rand = Random()
//        val index = rand.nextInt(list.size)
//        val word = list[index]
//        the_word.text = word
//
////        pick random definitions for the word
////        val defns = ArrayList<String>()
//        defns.add("a greeting")
//        defns.add("sth you say when you are done talking")
//        defns.add("a dude")
//        defns.add("another name for a duck")
//        defns.add("the President")
//        defns.add("nothing at all")
//        defns.shuffle()


//        read the content of the file
        readDictionaryFile()

        val rand = Random()
        val index = rand.nextInt(words.size)
        val word = words[index]

        the_word.text = word
        defns.clear()
        defns.add(wordToDefn[word]!!)
        words.shuffle()
        for (otherWords in words.subList(0, 4)) {
            defns.add(wordToDefn[otherWords]!!)
            if (otherWords == word || defns.size == 5) {
                continue
            }
        }
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

    private fun readDictionaryFile() {
        val reader = Scanner(resources.openRawResource(R.raw.winequalityred))
        while (reader.hasNextLine()) {
            val line = reader.nextLine()
//            debug whether the reading function goes well
            Log.d("Marty","the line is: $line")
//            \t: space  \r: enter \n: enter to a new line
            val pieces = line.split(";")
            if (pieces.size >= 2) {
                words.add(pieces[0])
                wordToDefn.put(pieces[0], pieces[1])
            }
        }
    }
}