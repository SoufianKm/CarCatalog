package com.soufianekamma.carcatalog.home.presentation.car_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soufianekamma.carcatalog.home.domain.repository.CarRepository
import com.soufianekamma.carcatalog.home.presentation.util.sendEvent
import com.soufianekamma.carcatalog.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val carRepository: CarRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CarViewState())
    val state = _state.asStateFlow()

    init {
        getCars()
    }

    fun getCars(isRefreshing: Boolean = false) {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = !isRefreshing, isRefreshing = isRefreshing)
            }
            carRepository.getCarsFromLocalJson().onRight { cars ->
                _state.update {
                    it.copy(
                        cars = cars
                    )
                }
            }.onLeft { error ->
                _state.update { it.copy(error = error.error.message) }
                sendEvent(Event.Snackbar(error.error.message))
            }
            _state.update {
                it.copy(isLoading = false, isRefreshing = false)
            }
        }
    }
}