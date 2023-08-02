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
    primary = PrimaryTopBarColor,
    primaryVariant = PrimaryVariant,
    secondary = Secondary,
    secondaryVariant = Color.Gray,
    background = DarkThemeBackground,
    surface = PrimaryTopBarColor,
    error = ErrorColor,
    onPrimary = TopBarTextColor,
    onSecondary = Color.Yellow,
    onBackground = DarkThemeText,
    onSurface = PrimaryTopBarColor,
    onError = ErrorColor,
    isLight = false
)

private val LightColors = Colors(
    primary = PrimaryTopBarColor,
    primaryVariant = PrimaryVariant,
    secondary = Secondary,
    secondaryVariant = Color.Green,
    background = LightThemeBackground,
    surface = LightThemeSurface,
    error = ErrorColor,
    onPrimary = TopBarTextColor,
    onSecondary = Color.White,
    onBackground = LightThemeText,
    onSurface = PrimaryTopBarColor,
    onError = ErrorColor,
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