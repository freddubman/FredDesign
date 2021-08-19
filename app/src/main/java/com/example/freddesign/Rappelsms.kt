package com.example.freddesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Rappelsms : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rappelsms)

        val envoi = findViewById<Button>(R.id.btnEnvoi)

        envoi.setOnClickListener{
            Toast.makeText(this,
                "Demande de rappel envoyée", Toast.LENGTH_SHORT).show()
        }


    }
}