package com.example.drawernav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.drawernav.Adapters.MascotasAdapter
import com.example.drawernav.Models.Pet


class AnimalesFragment : Fragment() {

    private lateinit var petsRecyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var petsAdapter: MascotasAdapter
    private lateinit var fullPetList: List<Pet>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_animales, container, false)

        petsRecyclerView = view.findViewById(R.id.petsRecyclerView)
        searchView = view.findViewById(R.id.searchView)

        // Lista de ejemplo
        fullPetList = listOf(
            Pet(1, "Max", "Perro", "Labrador", 5, 5),
            Pet(2, "Luna", "Gato", "Siamés", 3, 5),
            Pet(3, "Rocky", "Perro", "Bulldog", 2, 5)
        )

        petsAdapter = MascotasAdapter(fullPetList)
        petsRecyclerView.layoutManager = LinearLayoutManager(context)
        petsRecyclerView.adapter = petsAdapter

        setupSearch()

        return view
    }

    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = fullPetList.filter { pet ->
                    pet.name.contains(newText.orEmpty(), ignoreCase = true) ||
                            pet.species.contains(newText.orEmpty(), ignoreCase = true) ||
                            pet.breed.contains(newText.orEmpty(), ignoreCase = true)
                }
                petsAdapter.updateData(filteredList)
                return true
            }
        })
    }
}