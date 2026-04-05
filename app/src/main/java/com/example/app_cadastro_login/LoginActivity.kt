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

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val campoEmail = findViewById<EditText>(R.id.editEmail)
        val campoSenha = findViewById<EditText>(R.id.editSenha)
        val botaoLogin = findViewById<Button>(R.id.btnLogin)
        val textoCadastro = findViewById<TextView>(R.id.txtCadastro)

        botaoLogin.setOnClickListener {
            val email = campoEmail.text.toString()
            val senha = campoSenha.text.toString()

            if(email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Erro! Campo Vazio", Toast.LENGTH_SHORT).show()
            } else if (email == "heudes@heudes.com" && senha == "123") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("User_Email", email)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show()
            }

        }
        textoCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }
}

