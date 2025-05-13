package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_paciente)

        val trocartela = findViewById<Button>(R.id.buttonLoginPaciente)
        trocartela.setOnClickListener {
            setContentView(R.layout.activity_login_paciente)
        }
        val telatrocar = findViewById<Button>(R.id.buttonCadastroPaciente)
        telatrocar.setOnClickListener {
            setContentView(R.layout.activity_cadastro_paciente)
        }
    }
}
