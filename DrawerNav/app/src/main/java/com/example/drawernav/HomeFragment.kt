package com.example.drawernav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val userName = view.findViewById<TextView>(R.id.userName)
        val userEmail = view.findViewById<TextView>(R.id.userEmail)
        val userPhone = view.findViewById<TextView>(R.id.userPhone)
        val userAddress = view.findViewById<TextView>(R.id.userAddress)

        
        userName.text = "Juan Pérez"
        userEmail.text = "juan.perez@example.com"
        userPhone.text = "+34 600 123 456"
        userAddress.text = "Calle Falsa 123, Madrid"

        val salirButton = view.findViewById<Button>(R.id.SalirButton)

        salirButton.setOnClickListener {
            requireActivity().finish()
        }

        return view




    }




}