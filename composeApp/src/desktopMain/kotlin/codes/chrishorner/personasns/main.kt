package codes.chrishorner.personasns

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.jetbrains.compose.resources.stringResource
import personaim.composeapp.generated.resources.Res
import personaim.composeapp.generated.resources.app_name

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = stringResource(Res.string.app_name),
    ) {
        App()
    }
}