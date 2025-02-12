package com.soufianekamma.carcatalog.home.data.repository

import arrow.core.Either
import com.soufianekamma.carcatalog.home.data.local.CarsFromLocalJson
import com.soufianekamma.carcatalog.home.data.mapper.toNetworkError
import com.soufianekamma.carcatalog.home.data.remote.CarApi
import com.soufianekamma.carcatalog.home.domain.model.Car
import com.soufianekamma.carcatalog.home.domain.model.NetworkError
import com.soufianekamma.carcatalog.home.domain.repository.CarRepository
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

class CarRepositoryImpl @Inject constructor(
    private val carApi: CarApi,
    private val localCars: CarsFromLocalJson
) : CarRepository {
    override suspend fun getCars(): Either<NetworkError, List<Car>> {

        return Either.catch {
            carApi.getCars()
        }.mapLeft { it.toNetworkError() }
    }

    override suspend fun getCarsFromLocalJson(): Either<NetworkError, List<Car>> {
        return Either.catch {
            delay(3.seconds)
            localCars.getCarsFromLocalJson()
        }.mapLeft { it.toNetworkError() }
    }


}