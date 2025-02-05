package com.soufianekamma.carcatalog.home.data.remote

import com.soufianekamma.carcatalog.home.domain.model.Car
import retrofit2.http.GET

interface CarApi {


    @GET("cars")
    suspend fun getCars(): List<Car>
}