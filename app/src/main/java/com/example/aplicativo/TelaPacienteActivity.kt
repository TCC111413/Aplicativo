package com.example.aplicativo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button


class TelaPacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_paciente)

        val botao1 = findViewById<Button>(R.id.buttonLoginPaciente)
        botao1.setOnClickListener {
            val intent = Intent(this, TelaLoginPacienteActivity::class.java)
            startActivity(intent)
        }

        val botao2 = findViewById<Button>(R.id.buttonCadastroPaciente)
        botao2.setOnClickListener {
            val intent = Intent(this, TelaCadastroPacienteActivity::class.java)
            startActivity(intent)
        }
    }
}