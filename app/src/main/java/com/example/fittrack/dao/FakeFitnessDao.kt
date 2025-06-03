package com.example.fittrack.dao

import com.example.fittrack.dataclass.FitnessActivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FakeFitnessDao : FitnessDao {

    // This is like our pretend database table
    private val activityList = mutableListOf<FitnessActivity>()

    // This will let us observe the list like a Flow
    private val flow = MutableStateFlow<List<FitnessActivity>>(emptyList())

    override fun getAllActivities(): Flow<List<FitnessActivity>> {
        return flow.asStateFlow()
    }

    override suspend fun insertActivity(activity: FitnessActivity) {
        activityList.add(activity)
        emitFlow()
    }

    override suspend fun updateActivity(activity: FitnessActivity) {
        val index = activityList.indexOfFirst { it.id == activity.id }
        if (index != -1) {
            activityList[index] = activity
            emitFlow()
        }
    }

    override suspend fun deleteActivity(activity: FitnessActivity) {
        activityList.removeIf { it.id == activity.id }
        emitFlow()
    }

    // Helper function to push updates into the Flow
    private fun emitFlow() {
        // Sort by date descending to mimic your original query
        flow.value = activityList.sortedByDescending { it.date }
    }
}
