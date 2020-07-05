package com.example.cs193aandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_library.*

class LibraryActivity : AppCompatActivity() {
    companion object{
        val GLOBALPARA = ""
//    LibraryActivity.GLOBALPARA
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
        
//        Library Picasso
        Picasso.get()
            .load(R.drawable.a)
            .into(photo_image)
        Thread.sleep(200)
    }

    fun onclickShow(view: View) {
//        val pups = resources.getStringArray(R.array.addressArray)
//        val index = spinner.selectedItemPosition
//        val pup = pups[index]

//        Library yoyo
        YoYo.with(Techniques.Wobble)
            .duration(1000)
            .playOn(button)
    }
}