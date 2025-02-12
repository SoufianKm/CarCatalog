package com.soufianekamma.carcatalog.home.presentation.car_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.soufianekamma.carcatalog.R
import com.soufianekamma.carcatalog.home.domain.model.Car

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CarCard(
    modifier: Modifier = Modifier, car: Car
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            GlideImage(
                model = car.imageUrl,
                contentDescription = car.title,
                modifier = modifier
                    .fillMaxSize()
                    .height(250.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            ) {
                it.error(placeholder(R.drawable.carplaceholder))
                    .placeholder(R.drawable.carplaceholder)
                    .load(car.imageUrl)
            }
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 1f)),
                            startY = 200f,
                            endY = 700f
                        )
                    )
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(15.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = car.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = car.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                )
            }

        }
    }
}