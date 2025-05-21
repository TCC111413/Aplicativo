package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TelaAbaMedicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aba_medico)

        val botaoMedicos = findViewById<Button>(R.id.buttonAbaMedicos)
        botaoMedicos.setOnClickListener {
            val intent = Intent(this, TelaEscolhaPacienteActivity::class.java)
            startActivity(intent)
        }

        val botaoPacientes = findViewById<Button>(R.id.buttonAbaPacientes)
        botaoPacientes.setOnClickListener {
            val intent = Intent(this, TelaEscolhaMedicoActivity::class.java)
            startActivity(intent)
        }
    }
}
