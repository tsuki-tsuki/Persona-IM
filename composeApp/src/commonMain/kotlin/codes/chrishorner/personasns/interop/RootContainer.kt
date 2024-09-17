package codes.chrishorner.personasns.interop

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
expect fun RootContainer(
    statusBarColor: Color = Color.Transparent,
    navigationBarColor: Color = Color.Transparent,
    content: @Composable () -> Unit,
)