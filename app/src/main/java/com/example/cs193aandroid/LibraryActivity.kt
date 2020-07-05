package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
    }

    fun onclickShow(view: View) {
        val pups = resources.getStringArray(R.array.addressArray)
        val index = spinner.selectedItemPosition
        val pup = pups[index]

        Picasso.get()
            .load(R.drawable.a)
            .into(photo_image)

    }
}