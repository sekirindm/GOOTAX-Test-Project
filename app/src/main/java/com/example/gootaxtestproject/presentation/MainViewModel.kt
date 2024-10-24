package com.example.gootaxtestproject.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gootaxtestproject.data.network.model.Suggestion
import com.example.gootaxtestproject.data.network.service.GootaxService
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import retrofit2.http.Query

@FlowPreview
class MainViewModel(private val service: GootaxService) : ViewModel() {

    private val _suggestions = MutableLiveData<List<Suggestion>>(emptyList())
    val suggestions: LiveData<List<Suggestion>> get() = _suggestions

    private val stateFlow = MutableStateFlow("")

    init {
        viewModelScope.launch {
            stateFlow.debounce(300).filter { it.isNotBlank() }.collect { query ->
                val response = service.getAddressSuggestions(
                    query,
                    "Token ebe92f2fe049ebbf1d3c457ac609fddca3abd85c"
                )
                if (response.isSuccessful) {
                    _suggestions.postValue(response.body()?.suggestions ?: emptyList())
                }
            }
        }
    }

    fun querySuggestion(query: String) {
        stateFlow.value = query
    }
}