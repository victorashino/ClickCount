package com.bicutoru.clickcount

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ClickCountViewModel : ViewModel() {

    private var count: Int = 0
    val _uiState = MutableStateFlow(0)
    var uiState: StateFlow<Int> = _uiState

    fun increment() {
        _uiState.value++
    }

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return ClickCountViewModel() as T
            }
        }
    }
}