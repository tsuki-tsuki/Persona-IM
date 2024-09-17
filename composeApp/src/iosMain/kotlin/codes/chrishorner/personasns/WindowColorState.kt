@file:Suppress("unused", "ObjectPropertyName")

package codes.chrishorner.personasns

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import platform.UIKit.UIColor

object WindowColorState {
    internal val _statusBarColor = MutableStateFlow(UIColor.clearColor)
    val statusBarColor = _statusBarColor.asStateFlow()
    internal val _navigationBarColor = MutableStateFlow(UIColor.clearColor)
    val navigationBarColor = _navigationBarColor.asStateFlow()
}