package com.example.aplicativo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
class activity_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paciente)

        val botaotrocar = findViewById<Button>(R.id.buttonSeguinte)
        botaotrocar.setOnClickListener{
            setContentView(R.layout.paciente2)
        }
    }
}
