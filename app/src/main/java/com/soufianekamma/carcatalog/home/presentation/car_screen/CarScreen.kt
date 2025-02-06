package com.soufianekamma.carcatalog.home.presentation.car_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.soufianekamma.carcatalog.home.presentation.car_screen.components.CarCard
import com.soufianekamma.carcatalog.home.presentation.util.components.LoadingDialog
import com.soufianekamma.carcatalog.home.presentation.util.components.MyTopAppBar

@Composable
fun CarScreen(
    snackbarHostState: SnackbarHostState,
    viewModel: CarViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    CarsList(
        state = state,
        snackbarHostState = snackbarHostState,
        refreshData = { viewModel.getCars(true) }
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsList(
    state: CarViewState, snackbarHostState: SnackbarHostState, refreshData: () -> Unit
) {

    val refreshState = rememberPullToRefreshState()

    LoadingDialog(isLoading = state.isLoading)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(title = "Car Catalog") },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { paddingValues ->

        PullToRefreshBox(modifier = Modifier
            .fillMaxSize().padding(paddingValues),
            state = refreshState,
            isRefreshing = state.isRefreshing,
            onRefresh = { refreshData() }) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
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

}