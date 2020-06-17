package com.example.cs193aandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_list_adapters.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class ListAdapters : AppCompatActivity() {
    private val ADD_WORD_CODE = 1234
    private var wordToDefn = HashMap<String, String>()
    private val words = ArrayList<String> ()
    private val defns = ArrayList<String> ()
//    private var myAdapter : ArrayAdapter<String>? = null
    private lateinit var myAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_adapters)

//        read the content of the file
        readDictionaryFile()

        setupList()

        definitions_list.setOnItemClickListener {_, _, index, _ ->
            val word = the_word.text.toString()
            val defnCorrect = wordToDefn[word]
            val defnChosen = defns[index]

            if (defnChosen == defnCorrect) {
                showToastNms(50, "you got it!")
                setupList()
            }
            else {
//                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
                showToastNms(100, "Wrong!")
                defns.removeAt(index)
                myAdapter.notifyDataSetChanged()
            }
        }

    }

    private fun setupList() {
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

        val rand = Random()
        val index = rand.nextInt(words.size)
        val word = words[index]

        the_word.text = word
        defns.clear()
        defns.add(wordToDefn[word]!!)
        words.shuffle()
        for (otherWords in words.subList(0, 5)) {
            if (otherWords == word || defns.size == 4) {
                continue
            }
            defns.add(wordToDefn[otherWords]!!)
        }
        defns.shuffle()

        myAdapter = ArrayAdapter<String> (this,
            android.R.layout.simple_list_item_1, defns)
//        for (defn in defns.subList(0, 4)) {
//
//        }
        definitions_list.adapter = myAdapter


    }

    private fun readDictionaryFile() {
//        val reader = Scanner(resources.openRawResource(R.raw.winequalityred))
//        while (reader.hasNextLine()) {
//            val line = reader.nextLine()
////            debug whether the reading function goes well
//            Log.d("Marty", "the line is: $line")
////            \t: space  \r: enter \n: enter to a new line
//            val pieces = line.split(";")
//            if (pieces.size >= 2) {
//                words.add(pieces[0])
//                wordToDefn.put(pieces[0], pieces[1])
//            }
//        }

        val reader = resources.openRawResource(R.raw.winequalityred).bufferedReader()
        val line = ArrayList<String>()
        line.clear()
        reader.useLines { lines -> lines.forEach { line.add(it) }}
        for (each in line) {
//        debug whether the reading function goes well
            Log.d("Marty","the line is: $each")
//        \t: space  \r: enter \n: enter to a new line
            val pieces = each.split(";")
            if (pieces.size >= 2) {
                words.add(pieces[0])
                wordToDefn[pieces[0]] = pieces[1]
            }
        }


    }

    fun addWordButtonClick(view: View) {
//        launch the AddWordActivity
        val myIntent = Intent(this, AddWordActivity::class.java)
        myIntent.putExtra("name", "marty")
        startActivityForResult(myIntent, ADD_WORD_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, myIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, myIntent)
        if (requestCode == ADD_WORD_CODE) {
//            val word = myIntent?.getStringExtra("word") ?:""
//            val defn = myIntent?.getStringExtra("defn") ?:""

//            val word = myIntent!!.getStringExtra("word")
//            val defn = myIntent.getStringExtra("defn")
            if (myIntent != null) {
                val word = myIntent.getStringExtra("word")
                val defn = myIntent.getStringExtra("defn")
                Toast.makeText(this, "Go back word: $word Defn: $defn", Toast.LENGTH_SHORT).show()
                words.add(word)
                wordToDefn[word] = defn // wordToDefn.put(word, defn)
            }
        }
    }

    private fun showToastNms(n: Long, s: String) {
        val toast = Toast.makeText(this, s, Toast.LENGTH_SHORT)
        toast.show()
        val handler = Handler()
        handler.postDelayed(Runnable { toast.cancel() }, n)
    }


}