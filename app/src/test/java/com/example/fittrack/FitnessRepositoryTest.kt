package com.example.fittrack

import com.example.fittrack.dao.FakeFitnessDao
import com.example.fittrack.dataclass.FitnessActivity
import com.example.fittrack.repo.FitnessRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue

@ExperimentalCoroutinesApi
class FitnessRepositoryTest {
    private lateinit var dao: FakeFitnessDao
    private lateinit var repository: FitnessRepository

    @Before
    fun setup() {
        dao = FakeFitnessDao()
        repository = FitnessRepository(dao)
    }

    @Test
    fun insertActivity_shouldReturnInFlow() = runTest {
        val activity = FitnessActivity(name = "Yoga", durationInMinutes = 30, date = "2024-07-14", type = "Yoga")
        repository.insertActivity(activity)

        val result = repository.getAllActivities().first()
        assertTrue(result.contains(activity))
    }
}