package codes.chrishorner.personasns.interop

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
actual fun RootContainer(
    statusBarColor: Color,
    navigationBarColor: Color,
    content: @Composable () -> Unit
) {
    // TODO set browser top bar color?
    // systemBarColor is not used
    content()
}