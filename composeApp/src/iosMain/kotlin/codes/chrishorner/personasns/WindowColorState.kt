@file:Suppress("unused", "ObjectPropertyName")

package codes.chrishorner.personasns

import androidx.compose.ui.graphics.Color
import codes.chrishorner.personasns.interop.RootContainerColor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import platform.UIKit.UIColor

private fun Color.toUIColor() = UIColor(
    red = this.red.toDouble(),
    green = this.green.toDouble(),
    blue = this.blue.toDouble(),
    alpha = this.alpha.toDouble(),
)

object WindowColorState {
    internal val rootContainerColorState =
        MutableStateFlow(RootContainerColor(backgroundColor = Color.Transparent))

    val statusBarColor = rootContainerColorState.map { it.statusBarColor.toUIColor() }
    val navigationBarColor = rootContainerColorState.map { it.navigationBarColor.toUIColor() }
    val backgroundColor = rootContainerColorState.map { it.backgroundColor.toUIColor() }
}
