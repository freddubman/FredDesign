package com.example.freddesign

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Rappelsms : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rappelsms)
        auth = Firebase.auth

        val btDeconnexion = findViewById<Button>(R.id.BTDeconnexion)
        val tvEmail = findViewById<TextView>(R.id.TVEmail)
        val tvVerifMail = findViewById<TextView>(R.id.TVVerifMail)


        val btVerifEmail = findViewById<Button>(R.id.BTVerifMail)
        auth = Firebase.auth
        val user = Firebase.auth.currentUser

        if (user != null) {
            tvEmail.text = user.email
        }

        if (user!!.isEmailVerified) {
            tvVerifMail.visibility = View.GONE
            btVerifEmail.visibility = View.GONE
        }

        btDeconnexion.setOnClickListener {
            auth.signOut()
            val ConnexionIntent = Intent(this, MainActivity::class.java)
            startActivity(ConnexionIntent)
        }

        btVerifEmail.setOnClickListener {
            user!!.sendEmailVerification()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            baseContext, "Un email de vérification vous a été envoyé",
                            Toast.LENGTH_SHORT).show()
                    }
                }
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

        val btRetour = findViewById<ImageButton>(R.id.BTRetour)

        btRetour.setOnClickListener {
            val MainActivity = Intent(this, MainActivity::class.java)
            startActivity(MainActivity)
        }

        val btRappel= findViewById<Button>(R.id.BTRappel)

        btRappel.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: antiste_frederic@yahoo.fr")
            intent.putExtra(Intent.EXTRA_TEXT, "Merci d'indiquer votre numéro de téléphone afin de vous rappeler :")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Texte automatique : Merci de me rappeler")
            startActivity(intent)
        }

    }
}