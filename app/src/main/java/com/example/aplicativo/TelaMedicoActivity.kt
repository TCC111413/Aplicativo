package com.example.aplicativo

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TelaMedicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_medico)

        val nomeEditText = findViewById<EditText>(R.id.editTextNomeMedico)
        val crmEditText = findViewById<EditText>(R.id.editTextCRM)
        val botaoseguinte = findViewById<Button>(R.id.buttonseguinte)

        val regexCrm = Regex("^CRM-[A-Z]{2}\\s\\d{4,6}$")

        botaoseguinte.setOnClickListener {
            val nome = nomeEditText.text.toString().trim()
            val crm = crmEditText.text.toString().trim()

            if (nome.isEmpty() || crm.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                if (nome.isEmpty()) nomeEditText.error = "Campo obrigatório"
                if (crm.isEmpty()) crmEditText.error = "Campo obrigatório"
            } else if (!regexCrm.matches(crm)) {
                crmEditText.error = "CRM inválido. Ex: CRM-SP 123456"
            } else {
                val intent = Intent(this, TelaMedicoCadastro2::class.java)
                intent.putExtra("nomeMedico", nome)
                intent.putExtra("crmMedico", crm)
                startActivity(intent)
            }
        }
    }
}
