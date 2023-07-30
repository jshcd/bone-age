package es.jshcd.edadosea.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColors = Colors(
    primary = Purple80,
    primaryVariant = Pink80,
    secondary = PurpleGrey80,
    secondaryVariant = Color.Gray,
    background = Color.White,
    surface = Color.Yellow,
    error = Color.Red,
    onPrimary = Color.DarkGray,
    onSecondary = Color.DarkGray,
    onBackground = Color.White,
    onSurface = Color.Green,
    onError = Color.Magenta,
    isLight = false
)

private val LightColors = Colors(
    primary = Gray50,
    primaryVariant = Pink40,
    secondary = PurpleGrey40,
    secondaryVariant = Color.Green,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    error = Color.Red,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    onError = Color.Magenta,
    isLight = true
)

@Composable
fun BoneAgeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
      darkTheme -> DarkColors
      else -> LightColors
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
      SideEffect {
        val window = (view.context as Activity).window
        window.statusBarColor = colorScheme.primary.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
      }
    }

    MaterialTheme(
      colors = colorScheme,
      typography = Typography,
      content = content
    )
}