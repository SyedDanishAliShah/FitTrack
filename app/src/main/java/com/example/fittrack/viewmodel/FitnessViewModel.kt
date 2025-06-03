package com.example.fittrack.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fittrack.dataclass.FitnessActivity
import com.example.fittrack.repo.FitnessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class FitnessViewModel @Inject constructor(
    private val repository: FitnessRepository
) : ViewModel() {

    val activities = repository.getAllActivities()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    fun addActivity(activity: FitnessActivity) = viewModelScope.launch {
        repository.insertActivity(activity)
    }

    fun deleteActivity(activity: FitnessActivity) = viewModelScope.launch {
        repository.deleteActivity(activity)
    }
}
