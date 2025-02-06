package com.soufianekamma.carcatalog.home.presentation.car_screen

import com.soufianekamma.carcatalog.home.domain.model.Car

data class CarViewState(
    val cars: List<Car> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = false
)
