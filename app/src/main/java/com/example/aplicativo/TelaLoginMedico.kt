package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaLoginMedico : AppCompatActivity() {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextSenha: EditText
    private lateinit var botaoSeguinte: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_medico)

        editTextEmail = findViewById(R.id.editTextEmailMedicoLogin)
        editTextSenha = findViewById(R.id.editTextSenhaMedico)
        botaoSeguinte = findViewById(R.id.buttonseguinte_)

        botaoSeguinte.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val senha = editTextSenha.text.toString().trim()

            var tudoCerto = true

            if (email.isEmpty()) {
                editTextEmail.error = "Preencha o e-mail"
                tudoCerto = false
            }

            if (senha.isEmpty()) {
                editTextSenha.error = "Preencha a senha"
                tudoCerto = false
            }

            if (tudoCerto) {
                Toast.makeText(this, "Login OK! Indo pra próxima tela...", Toast.LENGTH_SHORT).show()
                // Exemplo de redirecionamento
                val intent = Intent(this, Telafinalmedico::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
