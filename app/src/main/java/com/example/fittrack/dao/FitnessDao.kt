package com.example.fittrack.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.fittrack.dataclass.FitnessActivity
import kotlinx.coroutines.flow.Flow

@Dao
interface FitnessDao {
    @Query("SELECT * FROM activities ORDER BY date DESC")
    fun getAllActivities(): Flow<List<FitnessActivity>>

    @Insert
    suspend fun insertActivity(activity: FitnessActivity)

    @Update
    suspend fun updateActivity(activity: FitnessActivity)

    @Delete
    suspend fun deleteActivity(activity: FitnessActivity)
}
