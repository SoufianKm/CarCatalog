package com.soufianekamma.carcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.soufianekamma.carcatalog.home.presentation.car_screen.CarScreen
import com.soufianekamma.carcatalog.ui.theme.CarCatalogTheme
import com.soufianekamma.carcatalog.util.Event
import com.soufianekamma.carcatalog.util.EventBus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarCatalogTheme {
                val coroutineScope = rememberCoroutineScope()
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                val snackbarHostState = remember { SnackbarHostState() }

                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                        EventBus.events.collect { event ->
                            if (event is Event.Snackbar) {
                                coroutineScope.launch {
                                    snackbarHostState.showSnackbar(event.messsage)
                                }
                            }
                        }
                    }
                }
                CarScreen(snackbarHostState)
            }
        }
    }
}