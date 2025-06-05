package com.example.drawernav

import Models.UsuarioModel
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView
import android.widget.Toast
import com.example.drawernav.apiservice.UsuarioApiService
import com.example.drawernav.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var loginButton: Button
private lateinit var emailEditText: EditText
private lateinit var passwordEditText: EditText
private lateinit var registerButton: TextView


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



        loginButton = findViewById(R.id.loginButton)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        registerButton = findViewById(R.id.tvRegisterLink)
        setupRegisterButton()
        setupLoginButton()



    }
    private fun setupLoginButton() {
        loginButton.setOnClickListener {
            if (isValidCredentials()) {
                doLogin(emailEditText.text.toString(), passwordEditText.text.toString())
            } else {
                showError("Credenciales incorrectas")
            }
        }
    }

    private fun setupRegisterButton() {
        registerButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun isValidCredentials(): Boolean {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun navigateToMainActivity(user: UsuarioModel) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("usuario", user)
        startActivity(intent)
        finish()
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToRegister() {

        startActivity(Intent(this, RegisterActivity::class.java))
        finish()

    }
    private fun doLogin(username: String, password: String) {
        val service = RetrofitClientInstance.retrofit.create(UsuarioApiService::class.java)
        service.getUsuarioByNombre(username).enqueue(object : Callback<UsuarioModel> {
            override fun onResponse(
                call: Call<UsuarioModel>,
                response: Response<UsuarioModel>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val user = response.body()!!
                    if (user.contrasena == password) {
                        navigateToMainActivity(user)
                    } else {
                        showError("Usuario o contraseña incorrectos")
                    }
                } else {
                    showError("Usuario no encontrado")
                }
            }

            override fun onFailure(call: Call<UsuarioModel>, t: Throwable) {
                showError("Error de red: ${t.localizedMessage}")
            }
        })

}}