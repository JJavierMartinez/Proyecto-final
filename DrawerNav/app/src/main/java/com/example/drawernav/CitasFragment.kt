package com.example.drawernav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernav.Adapters.CitasAdapter
import com.example.drawernav.Models.Appointment
import java.text.SimpleDateFormat
import java.util.Locale


class CitasFragment : Fragment() {
    private lateinit var appointmentsAdapter: CitasAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflar manualmente el layout
        val view = inflater.inflate(R.layout.fragment_citas, container, false)

        // Obtener referencia al RecyclerView
        recyclerView = view.findViewById(R.id.rvAppointments)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadSampleData()
    }

    private fun setupRecyclerView() {
        appointmentsAdapter = CitasAdapter(emptyList())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = appointmentsAdapter
    }

    private fun loadSampleData() {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val sampleAppointments = listOf(
            Appointment(
                id = 1,
                type = "Consulta general",
                date = dateFormat.parse("15/06/2023 10:30")!!,
                petName = "Max",
                vetName = "Dr. Rodríguez",
                status = "Confirmada"
            ),
            Appointment(
                id = 2,
                type = "Vacunación anual",
                date = dateFormat.parse("17/06/2023 16:15")!!,
                petName = "Luna",
                vetName = "Dra. Pérez",
                status = "Pendiente"
            ),
            Appointment(
                id = 3,
                type = "Control postoperatorio",
                date = dateFormat.parse("20/06/2023 11:00")!!,
                petName = "Rocky",
                vetName = "Dr. Gómez",
                status = "Confirmada"
            )
        )
        appointmentsAdapter.updateData(sampleAppointments)
    }
}