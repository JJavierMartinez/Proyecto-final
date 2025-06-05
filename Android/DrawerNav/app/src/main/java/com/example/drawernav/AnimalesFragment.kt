package com.example.drawernav

import Models.PacienteModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernav.Adapters.MascotasAdapter
import com.example.drawernav.apiservice.UsuarioApiService
import com.example.drawernav.network.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalesFragment : Fragment() {

    private lateinit var petsRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var petsAdapter: MascotasAdapter
    private var fullPetList: List<PacienteModel> = emptyList()

    private val usuario by lazy {
        (activity as? MainActivity)?.usuarioLogueado
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_animales, container, false)

        petsRecyclerView = view.findViewById(R.id.petsRecyclerView)
        searchView = view.findViewById(R.id.searchView)

        petsAdapter = MascotasAdapter(emptyList())
        petsRecyclerView.layoutManager = LinearLayoutManager(context)
        petsRecyclerView.adapter = petsAdapter

        setupSearch()
        obtenerMascotas()

        return view
    }

    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = fullPetList.filter { mascota ->
                    mascota.nombre.contains(newText.orEmpty(), ignoreCase = true) ||
                            mascota.especie.contains(newText.orEmpty(), ignoreCase = true) ||
                            mascota.raza.contains(newText.orEmpty(), ignoreCase = true)
                }
                petsAdapter.updateData(filteredList)
                return true
            }
        })
    }

    private fun obtenerMascotas() {
        val user = usuario?: return


        if (user.rol.id == 1L || user.rol.id == 2L) {
            val service = RetrofitClientInstance.retrofit.create(UsuarioApiService::class.java)
            service.getTodosLosPacientes().enqueue(object : Callback<List<PacienteModel>> {
                override fun onResponse(
                    call: Call<List<PacienteModel>>,
                    response: Response<List<PacienteModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        fullPetList = response.body()!!
                        petsAdapter.updateData(fullPetList)
                    }
                }

                override fun onFailure(call: Call<List<PacienteModel>>, t: Throwable) {

                }
            })
        } else {
            val service = RetrofitClientInstance.retrofit.create(UsuarioApiService::class.java)
            service.getMascotasDeUsuario(user.id).enqueue(object : Callback<List<PacienteModel>> {
                override fun onResponse(
                    call: Call<List<PacienteModel>>,
                    response: Response<List<PacienteModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        fullPetList = response.body()!!
                        petsAdapter.updateData(fullPetList)
                    }
                }

                override fun onFailure(call: Call<List<PacienteModel>>, t: Throwable) {

                }
            })
        }
    }
}