package stream.swiftmoon.personasns.interop

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

internal class IosWindow : Window {
    override var statusBarColor: Int
        get() = Color.Transparent.toArgb()
        set(value) {
            // TODO implement
        }

    /**
     * There's no navigation bar in iOS, so we just return transparent
     */
    override var navigationBarColor: Int
        get() = Color.Transparent.toArgb()
        set(value) {
            /* no-op */
        }
}

@Composable
actual fun getLocalWindow(): Window = IosWindow()