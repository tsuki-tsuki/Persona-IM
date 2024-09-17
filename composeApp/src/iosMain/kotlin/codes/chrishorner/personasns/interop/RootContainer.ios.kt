package codes.chrishorner.personasns.interop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import codes.chrishorner.personasns.WindowColorState
import platform.UIKit.UIColor
import platform.UIKit.UIViewController

private fun Color.toUIColor() = UIColor(
    red = this.red.toDouble(),
    green = this.green.toDouble(),
    blue = this.blue.toDouble(),
    alpha = this.alpha.toDouble(),
)

@Suppress("unused", "FunctionName")
fun IosRootContainerEntryPoint(
    createRootContainer: () -> UIViewController
): UIViewController = createRootContainer()

@Composable
actual fun RootContainer(
    statusBarColor: Color,
    navigationBarColor: Color,
    content: @Composable () -> Unit
) {
    // Create Compose view that wrap SwiftUI view that also contains Compose view
    SideEffect {
        WindowColorState._statusBarColor.value = statusBarColor.toUIColor()
        WindowColorState._navigationBarColor.value = navigationBarColor.toUIColor()
    }

    content()
}