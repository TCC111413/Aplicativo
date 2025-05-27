package com.example.aplicativo


import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
data class Medico(
    val nome: String? = null,
    val crm: String? = null,
    val telefone: String? = null,
    val email: String? = null,
    val senha: String? = null
)

class TelaCadastroMedicoActivity : AppCompatActivity() {


    private lateinit var telefoneEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var senhaEditText: EditText
    private lateinit var nomeEditText: EditText
    private lateinit var crmEditText: EditText
    private lateinit var botaoCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_medico)

        telefoneEditText = findViewById(R.id.editTextTelefone)
        emailEditText = findViewById(R.id.editTextEmail)
        senhaEditText = findViewById(R.id.editTextSenha)
        nomeEditText = findViewById(R.id.editTextNome)
        crmEditText = findViewById(R.id.editTextCRM)
        botaoCadastrar = findViewById(R.id.buttonCadastrar)

        botaoCadastrar.setOnClickListener {
            val nome = nomeEditText.text.toString().trim()
            val crm = crmEditText.text.toString().trim()
            val telefone = telefoneEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val senha = senhaEditText.text.toString().trim()

            var tudoCerto = true

            if (nome.isEmpty() || crm.isEmpty() || telefone.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
            if (!isValidEmail(email)) {
                emailEditText.error = "Email inválido"
                tudoCerto = false
            }
            if (senha.length < 6) {
                senhaEditText.error = "A senha deve ter no mínimo 6 caracteres"
                tudoCerto = false
            }
            if (tudoCerto) {
                register(nome, crm, telefone, email, senha)
            }

        }
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun salvarNoFirebase(
        nome: String,
        crm: String,
        telefone: String,
        email: String,
        senha: String
    ) {
        val database = FirebaseDatabase.getInstance()
        val referencia = database.getReference("medicos")

        val medico = Medico(nome, crm, telefone, email, senha)
        val medicoId = referencia.push().key ?: ""

        referencia.child(medicoId).setValue(medico)
            .addOnSuccessListener {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Erro ao cadastrar: ${it.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun register(
        nome: String,
        crm: String,
        telefone: String,
        email: String,
        senha: String
    ) {
        val auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email, senha)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    salvarNoFirebase(nome, crm, telefone, email, senha)

                    val user = auth.currentUser
                    Toast.makeText(
                        this,
                        "Registrado com sucesso: ${user?.email}",
                        Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, TelaLoginMedicoActivity::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(
                        this,
                        "Erro ao registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}