package com.soufianekamma.carcatalog.home.data.repository

import arrow.core.Either
import com.soufianekamma.carcatalog.home.data.mapper.toNetworkError
import com.soufianekamma.carcatalog.home.data.remote.CarApi
import com.soufianekamma.carcatalog.home.domain.model.Car
import com.soufianekamma.carcatalog.home.domain.model.NetworkError
import com.soufianekamma.carcatalog.home.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(
    private val carApi: CarApi
) : CarRepository {
    override suspend fun getCars(): Either<NetworkError, List<Car>> {

        return Either.catch {
            carApi.getCars()
        }.mapLeft { it.toNetworkError() }
    }
}