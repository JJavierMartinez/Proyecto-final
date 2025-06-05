package com.example.drawernav

import Models.UsuarioModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class HomeFragment : Fragment() {


    private val usuario by lazy {
        (activity as? MainActivity)?.usuarioLogueado
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val userName = view.findViewById<TextView>(R.id.userName)
        val userApellidos = view.findViewById<TextView>(R.id.userApellidos)
        val userEmail = view.findViewById<TextView>(R.id.userEmail)
        val userPhone = view.findViewById<TextView>(R.id.userPhone)
        val userRol = view.findViewById<TextView>(R.id.userRol)
        val salirButton = view.findViewById<Button>(R.id.SalirButton)

        usuario?.let { user ->
            userName.text = user.user
            userApellidos.text = user.apellidos
            userEmail.text = user.correo
            userPhone.text = user.telefono
            userRol.text = user.rol.rol
        }

        salirButton.setOnClickListener {
            requireActivity().finish()
        }

        return view
    }
}