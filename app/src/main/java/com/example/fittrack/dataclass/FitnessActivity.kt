package com.example.fittrack.dataclass

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activities")
data class FitnessActivity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val durationInMinutes: Int,
    val date: String, // e.g. "2024-07-14"
    val type: String // e.g. "Running", "Yoga"
)

