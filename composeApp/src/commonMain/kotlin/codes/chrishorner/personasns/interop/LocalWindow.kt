package codes.chrishorner.personasns.interop

import androidx.annotation.ColorInt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

val LocalWindow
    @Composable get() = getLocalWindow().let { compositionLocalOf { it } }

interface Window {
    @get:ColorInt
    @set:ColorInt
    var statusBarColor: Int

    @get:ColorInt
    @set:ColorInt
    var navigationBarColor: Int
}

@Composable
expect fun getLocalWindow(): Window