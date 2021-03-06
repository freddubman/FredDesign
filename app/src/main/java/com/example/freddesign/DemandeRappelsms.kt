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

class DemandeRappelsms : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demande_rappelsms)

        val btRegister = findViewById<Button>(R.id.BTRegister)
        val btForgot = findViewById<Button>(R.id.BTForgot)
        val etPassword = findViewById<EditText>(R.id.ETPassword)
        val etEmail = findViewById<EditText>(R.id.ETEmail)
        val btConnect = findViewById<Button>(R.id.BTConnect)

        auth = Firebase.auth

        //Ouvre la page d'enregistrement
        btRegister.setOnClickListener {
            val RegisterIntent = Intent(this, RegisterActivity2::class.java)
            startActivity(RegisterIntent)
        }
        //Ouvre la page de mot de passe oublié
        btForgot.setOnClickListener {
            val ForgotIntent = Intent(this, ForgotActivity::class.java)
            startActivity(ForgotIntent)
        }

        //Connexion à mon compte créé sur la page register
        btConnect.setOnClickListener{
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            if (email.isNotEmpty() and (password.isNotEmpty())){
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(baseContext, "Connexion réussie",
                                Toast.LENGTH_SHORT).show()
                            val Rappelsms = Intent(this, Rappelsms::class.java)
                            startActivity(Rappelsms)
                        } else {
                            Toast.makeText(baseContext, "Erreur de connexion",
                                Toast.LENGTH_SHORT).show()
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
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            val Rappelsms = Intent(this, Rappelsms::class.java)
            startActivity(Rappelsms)

        }
    }

}