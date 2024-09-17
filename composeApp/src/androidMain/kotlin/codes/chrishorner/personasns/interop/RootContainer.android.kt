package codes.chrishorner.personasns.interop

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun RootContainer(
    statusBarColor: Color,
    navigationBarColor: Color,
    content: @Composable () -> Unit
) {
    val activity = LocalContext.current as Activity
    SideEffect {
        activity.window.statusBarColor = statusBarColor.toArgb()
        activity.window.navigationBarColor = navigationBarColor.toArgb()
    }

    content()
}