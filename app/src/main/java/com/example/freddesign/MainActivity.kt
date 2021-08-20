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

        val rappel = findViewById<ImageButton>(R.id.BTrappel)
            rappel.setOnClickListener {
            val DemandeRappelsms = Intent(this, DemandeRappelsms::class.java)
            startActivity(DemandeRappelsms)
        }

        val envoimail = findViewById<ImageButton>(R.id.BTmail)
            envoimail.setOnClickListener {
            val EnvoiMail = Intent(this, EnvoiMail::class.java)
            startActivity(EnvoiMail)
        }

        val toLinkedin = findViewById<ImageButton>(R.id.BTlinkedin)
        toLinkedin.setOnClickListener {
            val ToLinkedin = Intent(this, ToLinkedin::class.java)
            startActivity(ToLinkedin)
        }

        val toFacebook = findViewById<ImageButton>(R.id.BTfacebook)
            toFacebook.setOnClickListener {
            val ToFacebook = Intent(this, ToFacebook::class.java)
            startActivity(ToFacebook)
        }



        /*val appel = findViewById<ImageButton>(R.id.BTappel)
        appel.setOnClickListener {
           Intent(Intent.ACTION_CALL_BUTTON,Uri.parse("0692305662"))
            }*/

        }

    }