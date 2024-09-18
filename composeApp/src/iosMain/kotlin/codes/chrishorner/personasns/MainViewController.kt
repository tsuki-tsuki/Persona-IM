package codes.chrishorner.personasns

import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.window.ComposeUIViewController

@OptIn(ExperimentalComposeApi::class)
@Suppress("unused", "FunctionName")
fun MainViewController() = ComposeUIViewController(configure = { opaque = false }) { App() }