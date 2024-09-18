package codes.chrishorner.personasns.interop

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun RootContainer(
    colors: RootContainerColor,
    content: @Composable (BoxScope.() -> Unit)
) {
    val activity = LocalContext.current as Activity
    SideEffect {
        activity.window.statusBarColor = colors.statusBarColor.toArgb()
        activity.window.navigationBarColor = colors.navigationBarColor.toArgb()
        activity.window.setBackgroundDrawable(ColorDrawable(colors.backgroundColor.toArgb()))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        content = content
    )
}