package com.example.lab_2.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lab_2.adapter.AnimalAdapter
import com.example.lab_2.databinding.FragmentAnimalListBinding
import com.example.lab_2.model.Animal
import com.example.lab_2.network.AnimalService
import com.example.lab_2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalListFragment : Fragment() {

    private var _binding: FragmentAnimalListBinding? = null
    private val binding get() = _binding!!

    private val adapter: AnimalAdapter by lazy {
        AnimalAdapter()
    }

    private val animalSevice: AnimalService by lazy {
        ApiClient.instance
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimalListBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        fetchData("")
        setupSearch()
    }

    private fun setupUI() {
        binding.animalList.adapter = adapter
    }


    private fun fetchData(query: String) {
        animalSevice.fetchAnimalList(query).enqueue(object : Callback<List<Animal>> {
            override fun onResponse(
                call: Call<List<Animal>>,
                response: Response<List<Animal>>
            ) {
                if (response.isSuccessful) {
                    println("HttpResponse: True")
                    adapter.submitList(response.body())
                } else {
                    println("HttpResponse: False")
                    showError("Failed to fetch data: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                showError("Network error: ${t.message}")
            }
        })
        println("HttpResponse: 2+2")
    }


    private fun setupSearch() {
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                fetchData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }


    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}