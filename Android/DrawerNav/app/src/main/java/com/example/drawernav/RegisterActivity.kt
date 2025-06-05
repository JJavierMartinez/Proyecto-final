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
import com.example.drawernav.network.RetrofitClientInstance
import com.example.drawernav.apiservice.UsuarioApiService
import Models.UsuarioModel
import Models.RolModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var tilUsername: TextInputLayout
    private lateinit var tilSurname: TextInputLayout
    private lateinit var tilDni: TextInputLayout
    private lateinit var tilPhone: TextInputLayout
    private lateinit var tilEmail: TextInputLayout
    private lateinit var tilPassword: TextInputLayout
    private lateinit var tilConfirmPassword: TextInputLayout

    private lateinit var etUsername: TextInputEditText
    private lateinit var etSurname: TextInputEditText
    private lateinit var etDni: TextInputEditText
    private lateinit var etPhone: TextInputEditText
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

        // Inicializar vistas
        tilUsername = findViewById(R.id.tilUsername)
        tilSurname = findViewById(R.id.tilSurname)
        tilDni = findViewById(R.id.tilDni)
        tilPhone = findViewById(R.id.tilPhone)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirmPassword = findViewById(R.id.tilConfirmPassword)

        etUsername = findViewById(R.id.etUsername)
        etSurname = findViewById(R.id.etSurname)
        etDni = findViewById(R.id.etDni)
        etPhone = findViewById(R.id.etPhone)
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
        val apellidos = etSurname.text.toString().trim()
        val dni = etDni.text.toString().trim()
        val username = etUsername.text.toString().trim()
        val telefono = etPhone.text.toString().trim()
        val correo = etEmail.text.toString().trim()
        val contrasena = etPassword.text.toString()

        val rol = RolModel(id = 3, rol = "USUARIO", descripcion = "Dueños de mascotas con permisos limitados", usuarios = emptyList())

        val usuario = UsuarioModel(

            apellidos = apellidos,
            DNI = dni,
            user = username,
            fecha_nac = null,
            fecha_alta = null,
            telefono = telefono,
            correo = correo,
            contrasena = contrasena,
            rol = rol,

        )

        val usuarioApi = RetrofitClientInstance.retrofit.create(UsuarioApiService::class.java)

        usuarioApi.crearUsuario(usuario).enqueue(object : Callback<UsuarioModel> {
            override fun onResponse(call: Call<UsuarioModel>, response: Response<UsuarioModel>) {
                if (response.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    rootLayout.postDelayed({
                        navigateToLogin()
                    }, 1500)
                } else {
                    Snackbar.make(rootLayout, "Error en el registro (${response.code()})", Snackbar.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<UsuarioModel>, t: Throwable) {
                Snackbar.make(rootLayout, "Fallo de conexión: ${t.message}", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    private fun validateForm(): Boolean {
        val surname = etSurname.text.toString().trim()
        val dni = etDni.text.toString().trim()
        val username = etUsername.text.toString().trim()
        val phone = etPhone.text.toString().trim()
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

        return when {
            username.isEmpty() -> {
                tilUsername.error = "Usuario requerido"
                false
            }
            surname.isEmpty() -> {
                tilSurname.error = "Apellidos requeridos"
                false
            }
            dni.isEmpty() -> {
                tilDni.error = "DNI requerido"
                false
            }
            !dni.matches(Regex("[0-9]{8}[A-Za-z]")) -> {
                tilDni.error = "DNI no válido"
                false
            }
            phone.isEmpty() -> {
                tilPhone.error = "Teléfono requerido"
                false
            }
            !phone.matches(Regex("\\d{9}")) -> {
                tilPhone.error = "Teléfono no válido"
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
                tilUsername.error = null
                tilSurname.error = null
                tilDni.error = null
                tilPhone.error = null
                tilEmail.error = null
                tilPassword.error = null
                tilConfirmPassword.error = null
                true
            }
        }
    }
}