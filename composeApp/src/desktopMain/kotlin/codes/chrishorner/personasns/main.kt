package codes.chrishorner.personasns

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import personasns.composeapp.generated.resources.Res
import personasns.composeapp.generated.resources.app_icon
import personasns.composeapp.generated.resources.app_name

fun main() = application {
    val state = rememberWindowState()

    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
        icon = painterResource(Res.drawable.app_icon),
        undecorated = true,
        transparent = true,
        state = state,
    ) {
        DecorWindow(
            modifier = Modifier.fillMaxSize(),
            onClickMinimize = { state.isMinimized = true },
            onClickClose = ::exitApplication,
        ) {
            App()
        }
    }
}