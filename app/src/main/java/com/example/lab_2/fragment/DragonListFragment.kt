package com.example.lab_2.fragment

import android.os.Bundle
import retrofit2.Call
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.lab_2.adapter.DragonAdapter
import com.example.lab_2.databinding.FragmentDragonListBinding
import com.example.lab_2.model.Dragon
import com.example.lab_2.network.ApiClient
import com.example.lab_2.network.DragonService
import okhttp3.Callback
import okhttp3.Response

class DragonListFragment : Fragment() {

    private var _binding: FragmentDragonListBinding? = null
    private val binding get() = _binding!!


    private val adapter: DragonAdapter by lazy {
        DragonAdapter()
    }

    private val dragonService: DragonService by lazy {
        ApiClient.instance
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDragonListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        fetchData("")
        setupSearch()
    }

    private fun setupUI() {

    }

    private fun fetchData(query: String) {
        dragonService.fetchDragonList(query).enqueue(object : Callback<List<Dragon>> {
            override fun onResponse(
                call: Call<List<Dragon>>,
                response: Response<List<Dragon>>
            ) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                } else {
                    showError("Failed to fetch data: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Dragon>>, t: Throwable) {
                showError("Network error: ${t.message}")
            }
        })
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
