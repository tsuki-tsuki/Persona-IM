package codes.chrishorner.personasns.interop

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import codes.chrishorner.personasns.WindowColorState

@Composable
actual fun RootContainer(
    colors: RootContainerColor,
    content: @Composable (BoxScope.() -> Unit)
) {
    SideEffect {
        WindowColorState.rootContainerColorState.value = colors
    }

    Box(modifier = Modifier.fillMaxSize(), content = content)
}