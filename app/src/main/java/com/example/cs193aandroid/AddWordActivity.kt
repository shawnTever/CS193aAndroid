package com.example.cs193aandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_word.*
import java.io.PrintStream

class AddWordActivity : AppCompatActivity() {
    private val WORDS_FILE_NAME = "extrawords.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
    }

    fun letsAddWord(view: View) {
        val word = word_to_add.text.toString()
        val defn = word_defination.text.toString()
        val line = "$word\t$defn"

        val outStream = PrintStream(
            openFileOutput(WORDS_FILE_NAME, Context.MODE_PRIVATE))
        outStream.println(line)
        outStream.close()

//        go back to main activity and "return" word + defn to them
        val myIntent = Intent()
        myIntent.putExtra("word", word)
        myIntent.putExtra("defn", defn)
        setResult(RESULT_OK, myIntent)
        finish()
    }
}