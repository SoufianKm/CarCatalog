package com.soufianekamma.carcatalog.home.domain.repository

import arrow.core.Either
import com.soufianekamma.carcatalog.home.domain.model.Car
import com.soufianekamma.carcatalog.home.domain.model.NetworkError

interface CarRepository {
    suspend fun getCars(): Either<NetworkError, List<Car>>

    suspend fun getCarsFromLocalJson(): Either<NetworkError, List<Car>>
}