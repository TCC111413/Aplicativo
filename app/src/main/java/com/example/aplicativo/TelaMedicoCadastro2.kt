package com.example.aplicativo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class TelaMedicoCadastro2 : AppCompatActivity() {

    private lateinit var telefoneEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var senhaEditText: EditText
    private lateinit var imageViewPerfil: ImageView
    private val PICK_IMAGE_REQUEST = 1
    private var imagemSelecionadaUri: Uri? = null // opcional

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_medico2)
        telefoneEditText = findViewById(R.id.editTextTelefone)
        emailEditText = findViewById(R.id.editTextEmail)
        senhaEditText = findViewById(R.id.editTextSenha)
        imageViewPerfil = findViewById(R.id.imageViewPerfil)
        val botaoSelecionarFoto = findViewById<Button>(R.id.buttonSelecionarFoto)
        val botaoSeguinte = findViewById<Button>(R.id.buttonSeguinte)

        botaoSelecionarFoto.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        botaoSeguinte.setOnClickListener {
            val telefone = telefoneEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val senha = senhaEditText.text.toString().trim()

            var tudoCerto = true

            if (telefone.isEmpty()) {
                telefoneEditText.error = "Preencha o telefone"
                tudoCerto = false
            }

            if (email.isEmpty()) {
                emailEditText.error = "Preencha o e-mail"
                tudoCerto = false
            }

            if (senha.isEmpty()) {
                senhaEditText.error = "Preencha a senha"
                tudoCerto = false
            }

            if (tudoCerto) {
                // se quiser mandar os dados pra próxima tela, pode por aqui
                Toast.makeText(this, "Tudo certo! Indo pra próxima tela...", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("telefone", telefone)
                intent.putExtra("email", email)
                intent.putExtra("senha", senha)
                intent.putExtra("imagemUri", imagemSelecionadaUri?.toString()) // pode ser nula
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            imagemSelecionadaUri = data.data
            imageViewPerfil.setImageURI(imagemSelecionadaUri)
        }
    }
}


