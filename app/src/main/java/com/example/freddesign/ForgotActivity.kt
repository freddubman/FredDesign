package com.example.freddesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        auth = Firebase.auth

        val btForgot = findViewById<Button>(R.id.BTFForgot)
        val etEmail = findViewById<EditText>(R.id.ETFMail)

        btForgot.setOnClickListener{
            val email = etEmail.text.toString()
            Firebase.auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(baseContext, "Un mail de réinitialisation du mot de passe vous a été envoyé",
                            Toast.LENGTH_SHORT).show()
                        val ConnexionIntent = Intent(this, MainActivity::class.java)
                        startActivity(ConnexionIntent)
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

    }
}