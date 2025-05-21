package com.example.aplicativo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button

class TelaEscolhaMedicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_escolha_medico)

        val botao1 = findViewById<Button>(R.id.buttonLoginMedico)
        botao1.setOnClickListener {
            val intent = Intent(this, TelaLoginMedicoActivity::class.java)
            startActivity(intent)
        }

        val botao2 = findViewById<Button>(R.id.buttonCadastroMedico)
        botao2.setOnClickListener {
            val intent = Intent(this, TelaCadastroMedicoActivity::class.java)
            startActivity(intent)
        }
    }
}