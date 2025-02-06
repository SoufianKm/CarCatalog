package com.soufianekamma.carcatalog.home.presentation.car_screen

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.soufianekamma.carcatalog.home.presentation.car_screen.components.CarCard
import com.soufianekamma.carcatalog.home.presentation.util.components.MyTopAppBar

@Composable
fun CarScreen(viewModel: CarViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    CarsList(state = state)

}


@Composable
fun CarsList(state: CarViewState) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Car Catalog") }) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(all = 8.dp)
        ) {
            items(state.cars) { car ->
                CarCard(car = car)
            }
        }
    }

}