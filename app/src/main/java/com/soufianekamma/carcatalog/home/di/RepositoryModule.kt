package com.soufianekamma.carcatalog.home.di

import com.soufianekamma.carcatalog.home.data.repository.CarRepositoryImpl
import com.soufianekamma.carcatalog.home.domain.repository.CarRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCarRepository(impl: CarRepositoryImpl): CarRepository
}