package com.example.cs193aandroid

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_flags.*

class FlagsActivity : AppCompatActivity() {
    private val COUNTRIES = listOf("Australia",
        "Brazil",
        "China",
        "Egypt",
        "France",
        "Germany",
        "Ghana",
        "Italy",
        "Japan",
        "Australia",
        "Brazil",
        "China",
        "Egypt",
        "France",
        "Germany")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)


        for (country in COUNTRIES) {
            createFlag(country)
        }

    }

    fun createFlag (countryName : String) {
        val flag = layoutInflater.inflate(R.layout.flag, null)
        val image = flag.findViewById<ImageButton>(R.id.flag_image)
        image.setOnClickListener {
            Toast.makeText(this, "You clicked $countryName", Toast.LENGTH_SHORT).show()
            showCountryInfo(countryName)
        }

        val countryNameView = flag.findViewById<TextView>(R.id.country_name)
        val visitedBox = flag.findViewById<CheckBox>(R.id.visited_box)

//        val flag = layoutInflater.inflate(R.layout.flag, grid_of_flags)
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)
//        layoutInflater.inflate(R.layout.flag, grid_of_flags)

        //        "Brazil"
        //        image -> R.drawable.b
        val countryName2 = countryName.toLowerCase()[0].toString().replace(" ","")
        val imageID = resources.getIdentifier(countryName2, "drawable", packageName)
        image.setImageResource(imageID)
        //        name -> "Brazil"
        countryNameView.text = countryName
        grid_of_flags.addView(flag)

    }

    fun showCountryInfo(countryName: String) {
////        read files send it to message
//        val countryName2 = countryName.toLowerCase()[0].toString().replace(" ","")
//        val textFileID = resources.getIdentifier(countryName2, "raw", packageName)
//        val fileText = resources.openRawResource(textFileID).bufferedReader().readText()

////        media player play songs
//        val countryName2 = countryName.toLowerCase()[0].toString().replace(" ","")
//        val mp3FileID = resources.getIdentifier(countryName2, "raw", packageName)
//        val mp = MediaPlayer.create(this, mp3FileID)
//        mp.start()



        val builder = AlertDialog.Builder(this)
        builder.setTitle("Info about $countryName")
        builder.setMessage("you clicked $countryName")

        builder.setPositiveButton("OK") {_,_ ->
//        mp.stop()
        }

        val dialog = builder.create()
        dialog.show()
    }
}