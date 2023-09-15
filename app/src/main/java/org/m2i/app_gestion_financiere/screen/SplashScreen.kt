package org.m2i.app_gestion_financiere.screen

import android.graphics.Paint.Align
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import org.m2i.app_gestion_financiere.navigation.GFScreens

@Composable
fun SplashScreen(navController: NavHostController) {
    val scale = remember{
        Animatable(0f)
    }

    LaunchedEffect(key1 = true ){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800, easing = {
                OvershootInterpolator(8f)
                    .getInterpolation(it)
            })
        )
        delay(2500L)
        navController.navigate(GFScreens.HomeScreen.name)
    }

    Surface(modifier = Modifier
        .padding(15.dp)
        .size(300.dp)
        .scale(scale = scale.value),
        shape = CircleShape,
        color = Color(0xFF9579C6),
        border = BorderStroke(width = 2.dp, color = Color(0xFF9579C6))
    ) {
        Column(modifier = Modifier.padding(3.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            Text(text = "Gestion financière",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displayMedium,
                color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "\"Maitriser votre budget \"",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White)

        }
    }
}
