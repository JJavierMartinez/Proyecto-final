package com.example.drawernav

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var tilName: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirmPassword: TextInputLayout

    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etConfirmPassword: TextInputEditText

    private lateinit var cbTerms: CheckBox
    private lateinit var btnRegister: Button
    private lateinit var tvLoginLink: TextView
    private lateinit var rootLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tilName = findViewById(R.id.tilName)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)

        cbTerms = findViewById(R.id.cbTerms)
        btnRegister = findViewById(R.id.btnRegister)
        tvLoginLink = findViewById(R.id.tvLoginLink)
        rootLayout = findViewById(R.id.rootLayout)

        btnRegister.setOnClickListener {
            if (validateForm()) {
                registerUser()
            }
        }

        tvLoginLink.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
    private fun registerUser() {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        rootLayout.postDelayed({
            navigateToLogin()
        }, 1500)
    }
    private fun validateForm(): Boolean {
        val name = etName.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        return when {
            name.isEmpty() -> {
                tilName.error = "Nombre requerido"
                false
            }
            email.isEmpty() -> {
                tilEmail.error = "Email requerido"
                false
            }
            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                tilEmail.error = "Email no válido"
                false
            }
            password.isEmpty() -> {
                tilPassword.error = "Contraseña requerida"
                false
            }
            password.length < 6 -> {
                tilPassword.error = "Mínimo 6 caracteres"
                false
            }
            confirmPassword != password -> {
                tilConfirmPassword.error = "Las contraseñas no coinciden"
                false
            }
            !cbTerms.isChecked -> {
                Snackbar.make(rootLayout, "Debes aceptar los términos", Snackbar.LENGTH_SHORT).show()
                false
            }
            else -> {
                tilName.error = null
                tilEmail.error = null
                tilPassword.error = null
                tilConfirmPassword.error = null
                true
            }
        }
    }
}