package com.example.aplicativo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            val botaotrocar = findViewById<Button>(R.id.idbuttonPaciente)
            botaotrocar.setOnClickListener{
                setContentView(R.layout.activity_tela_paciente)
            }


        }
    }
