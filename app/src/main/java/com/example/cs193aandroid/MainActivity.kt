package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blocklist.setOnItemClickListener { list, item, index, id ->
//            Toast.makeText(this, "you clicked item $index with id $id !", Toast.LENGTH_SHORT).show()
            val id = when (index) {
                0 -> R.drawable.a
                1 -> R.drawable.b
                2 -> R.drawable.c
                else -> R.drawable.d
            }
            block.setImageResource(id)
        }
    }

//    when equals if
    fun radioButtonClick(view: View){
        val id = when (view) {
            radioButtonA -> R.drawable.a
            radioButtonB -> R.drawable.b
            radioButtonC -> R.drawable.c
            else -> R.drawable.d
        }
        block.setImageResource(id)
//        when {
//            view.id == R.id.radioButtonA -> {
//                block.setImageResource(R.drawable.a)
//            }
//            view == radioButtonB -> {
//                block.setImageResource(R.drawable.b)
//            }
//            view == radioButtonC -> {
//                block.setImageResource(R.drawable.c)
//            }
//            view == radioButtonD -> {
//                block.setImageResource(R.drawable.d)
//            }
//        }
    }
}