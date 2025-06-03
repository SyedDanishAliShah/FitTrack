package com.example.fittrack.di

import android.content.Context
import com.example.fittrack.dao.FitnessDao
import com.example.fittrack.db.FitnessDatabase
import com.example.fittrack.repo.FitnessRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): FitnessDatabase =
        FitnessDatabase.getDatabase(context)

    @Provides
    fun provideDao(db: FitnessDatabase): FitnessDao = db.fitnessDao()

    @Provides
    fun provideRepository(dao: FitnessDao): FitnessRepository = FitnessRepository(dao)
}
