package codes.chrishorner.personasns.interop

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalView

internal class AndroidWindow(private val activity: Activity) : Window {
    override var statusBarColor: Int
        get() = activity.window.statusBarColor
        set(value) {
            activity.window.statusBarColor = value
        }

    override var navigationBarColor: Int
        get() = activity.window.navigationBarColor
        set(value) {
            activity.window.navigationBarColor = value
        }
}

@Composable
actual fun getLocalWindow(): Window = AndroidWindow(LocalView.current.context as Activity)