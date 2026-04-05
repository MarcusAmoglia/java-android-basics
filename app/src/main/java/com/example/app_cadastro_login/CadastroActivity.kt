package com.example.app_cadastro_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)

        val nome = findViewById<EditText>(R.id.editNome)
        val email = findViewById<EditText>(R.id.editEmailCadastro)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizarCadastro)

        btnFinalizar.setOnClickListener {
            val nomeDigitado = nome.text.toString()
            val emailDigitado = email.text.toString()

            if (nomeDigitado.isEmpty()){
                Toast.makeText(this,"Preencha o nome!", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Cadastro de $nomeDigitado realizado com sucesso!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("User_Email", emailDigitado)
                startActivity(intent)
                finish()
            }
        }
    }
}