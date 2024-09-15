package codes.chrishorner.personasns

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import personaim.composeapp.generated.resources.Res
import personaim.composeapp.generated.resources.optima_nova_black

val OptimaNova
    @Composable get() = FontFamily(
        Font(Res.font.optima_nova_black, weight = FontWeight.Black)
    )

val PersonaRed = Color(0xFFC41001)