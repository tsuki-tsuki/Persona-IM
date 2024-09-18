package codes.chrishorner.personasns.interop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import codes.chrishorner.personasns.updateThemeColor

@OptIn(ExperimentalStdlibApi::class)
@Composable
actual fun RootContainer(
    colors: RootContainerColor,
    content: @Composable (BoxScope.() -> Unit)
) {
    val argbString = colors.statusBarColor.toArgb().toHexString()
    val rgbaString = argbString.substring(2) + argbString.substring(0, 2)
    updateThemeColor("#$rgbaString")

    Box(modifier = Modifier.fillMaxSize().background(colors.backgroundColor), content = content)
}