package com.example.freddesign

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.view.View
import android.widget.Button

class ToFacebook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_facebook)

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

        val btRetour = findViewById<ImageButton>(R.id.BTRetour)

        btRetour.setOnClickListener {
            val MainActivity = Intent(this, MainActivity::class.java)
            startActivity(MainActivity)
        }

        val btOpenFacebook = findViewById<Button>(R.id.BTOpenFacebook)
        btOpenFacebook.setOnClickListener {
            val url = "fb://facewebmodal/f?href=https://www.facebook.com/reuniplans/" //  fb://facewebmodal/f?href=URL PAGE FACEBOOK permet d'ouvrir fia l'appli il est également possible d'ouvrir la page html via le navigateur par défaut en mettant simplement l'url
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

    }
}

