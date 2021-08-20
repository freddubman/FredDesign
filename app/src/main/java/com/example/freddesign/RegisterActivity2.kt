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

class RegisterActivity2 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        val etEMail = findViewById<EditText>(R.id.ETREmail)
        val etPassword1 = findViewById<EditText>(R.id.ETRPassword1)
        val etPassword2 = findViewById<EditText>(R.id.ETRPassword2)
        val btRegister = findViewById<Button>(R.id.BTRRegister)
        auth = Firebase.auth


        btRegister.setOnClickListener {
            val email = etEMail.text.toString()
            val password = etPassword1.text.toString()
            val password2 = etPassword2.text.toString()
            if (email.isNotEmpty() and (password.isNotEmpty() and (password2.isNotEmpty()))){
                if ( password != password2 )
                {
                    Toast.makeText(baseContext, "Les mots de passe ne correspondent pas",
                        Toast.LENGTH_SHORT).show()
                }
                else if (password.length < 5)
                {
                    Toast.makeText(baseContext, "Entrez un mot de passe plus long",
                        Toast.LENGTH_SHORT).show()
                }
                else {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {

                                val user = auth.currentUser
                                user!!.sendEmailVerification()
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(
                                                baseContext, "Un email de vérification vous a été envoyé",
                                                Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                val ConnexionIntent = Intent(this, MainActivity::class.java)
                                startActivity(ConnexionIntent)
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(
                                    baseContext, "Erreur",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                }
            }
            else {
                Toast.makeText(baseContext, "Veuillez remplir tous les champs",
                    Toast.LENGTH_SHORT).show()
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