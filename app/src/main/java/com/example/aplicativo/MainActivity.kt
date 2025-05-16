package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao1 = findViewById<Button>(R.id.idbuttonPaciente)
        botao1.setOnClickListener {
            val intent = Intent(this, TelaPacienteActivity::class.java)
            startActivity(intent)
        }

        val botao2 = findViewById<Button>(R.id.idbuttonMedico)
        botao2.setOnClickListener {
            val intent = Intent(this, TelaMedicoActivity::class.java)
            startActivity(intent)
        }
    }
}
