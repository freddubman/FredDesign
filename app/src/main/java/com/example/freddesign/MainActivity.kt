package com.example.freddesign

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btPage3 = findViewById<Button>(R.id.BTPage3)
        btPage3.setOnClickListener {
            val Page3 = Intent(this, Page3::class.java)
            startActivity(Page3)
        }

        val envoisms = findViewById<ImageButton>(R.id.BTrappel)
            envoisms.setOnClickListener {
            val Rappelsms = Intent(this, Rappelsms::class.java)
            startActivity(Rappelsms)
        }

        val envoimail = findViewById<ImageButton>(R.id.BTmail)
            envoimail.setOnClickListener {
            val EnvoiMail = Intent(this, EnvoiMail::class.java)
            startActivity(EnvoiMail)
        }



        /*val appel = findViewById<ImageButton>(R.id.BTappel)
        appel.setOnClickListener {
           Intent(Intent.ACTION_CALL_BUTTON,Uri.parse("0692305662"))
            }*/

        }

    }