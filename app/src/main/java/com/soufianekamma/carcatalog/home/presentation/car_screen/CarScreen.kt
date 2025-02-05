package com.soufianekamma.carcatalog.home.presentation.car_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.soufianekamma.carcatalog.home.presentation.car_screen.components.CarCard
import com.soufianekamma.carcatalog.home.presentation.util.components.MyTopAppBar

@Composable
fun CarScreen(modifier: Modifier = Modifier) {

}


@Composable
fun CarsList(state: CarViewState) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Car Catalog") }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            contentPadding = PaddingValues(all = 8.dp)
        ) {
            items(state.cars) { car ->
                CarCard(car = car)
            }
        }
    }
}