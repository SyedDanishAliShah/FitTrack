package com.example.fittrack.repo

import com.example.fittrack.dao.FitnessDao
import com.example.fittrack.dataclass.FitnessActivity
import jakarta.inject.Inject

class FitnessRepository @Inject constructor(private val dao: FitnessDao) {
    fun getAllActivities() = dao.getAllActivities()
    suspend fun insertActivity(activity: FitnessActivity) = dao.insertActivity(activity)
    suspend fun updateActivity(activity: FitnessActivity) = dao.updateActivity(activity)
    suspend fun deleteActivity(activity: FitnessActivity) = dao.deleteActivity(activity)
}
