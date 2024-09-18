package codes.chrishorner.personasns.interop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import codes.chrishorner.personasns.WindowColorState
import platform.UIKit.UIViewController

@Suppress("unused", "FunctionName")
fun IosRootContainerEntryPoint(
    createRootContainer: () -> UIViewController
): UIViewController = createRootContainer()

@Composable
actual fun RootContainer(
    colors: RootContainerColor,
    content: @Composable (BoxScope.() -> Unit)
) {
    // Create Compose view that wrap SwiftUI view that also contains Compose view
    SideEffect {
        WindowColorState.rootContainerColorState.value = colors
    }

    Box(modifier = Modifier.fillMaxSize().background(colors.backgroundColor), content = content)
}