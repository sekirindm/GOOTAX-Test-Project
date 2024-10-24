package com.example.gootaxtestproject.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gootaxtestproject.data.ItemList
import com.example.gootaxtestproject.databinding.FragmentSearchBinding
import com.example.gootaxtestproject.data.network.model.Suggestion
import com.example.gootaxtestproject.presentation.adapters.AddressAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    @OptIn(FlowPreview::class)
    private val viewModel by viewModel<MainViewModel>()

    private lateinit var adapter: AddressAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        return binding.root
    }

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.recyclerView

        adapter = AddressAdapter { selectedSuggestion ->
            val result = Bundle().apply {
                putString("selected_address", selectedSuggestion)
            }
            parentFragmentManager.setFragmentResult("requestKey", result)
            dismiss()
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.searchInput.addTextChangedListener { text ->
            viewModel.querySuggestion(text.toString())
        }
        viewModel.suggestions.observe(viewLifecycleOwner) { suggestion ->
            adapter.submitList(suggestionSubmit(suggestion))
        }
    }

    private fun suggestionSubmit(address: List<Suggestion>): List<ItemList> {
        return address.map { ItemList.AddressItemsList(it) }
    }
}