package codes.chrishorner.personasns.interop

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class RootContainerColor(
    val statusBarColor: Color = Color.Transparent,
    val navigationBarColor: Color = Color.Transparent,
    val backgroundColor: Color,
)

@Composable
expect fun RootContainer(
    colors: RootContainerColor = RootContainerColor(backgroundColor = Color.Gray),
    content: @Composable (BoxScope.() -> Unit),
)