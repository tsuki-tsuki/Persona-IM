package codes.chrishorner.personasns.interop

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

/**
 * There's no meaning to set status bar and navigation bar in Desktop, so we just implement a dummy class.
 */
internal class DesktopWindow : Window {
    override var statusBarColor: Int
        get() = Color.Transparent.toArgb()
        set(value) {
            /* no-op */
        }
    override var navigationBarColor: Int
        get() = Color.Transparent.toArgb()
        set(value) {
            /* no-op */
        }
}

@Composable
actual fun getLocalWindow(): Window = DesktopWindow()