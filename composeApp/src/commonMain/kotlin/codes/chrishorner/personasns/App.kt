package codes.chrishorner.personasns

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import codes.chrishorner.personasns.interop.RootContainer
import codes.chrishorner.personasns.interop.RootContainerColor
import kotlinx.collections.immutable.toImmutableList
import org.jetbrains.compose.resources.painterResource
import personasns.composeapp.generated.resources.Res
import personasns.composeapp.generated.resources.bg_splatter_background
import personasns.composeapp.generated.resources.logo_im
import personasns.composeapp.generated.resources.next

@Composable
fun App() {
    val transcriptState = rememberTranscriptState()
    var season by remember { mutableStateOf(Season.NONE) }

    RootContainer(
        colors = RootContainerColor(
            statusBarColor = Color.Black.copy(alpha = 0.3f),
            navigationBarColor = Color.Transparent,
            backgroundColor = PersonaRed,
        )
    ) {
        BackgroundParticles(season)

        Image(
            painter = painterResource(Res.drawable.bg_splatter_background),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .statusBarsPadding()
                .offset(y = (-16).dp)
        )

        val entries = transcriptState.entries
        Transcript(entries)

        Row(
            modifier = Modifier.statusBarsPadding()
        ) {
            SeasonMenu(
                hostElement = {
                    Image(
                        painter = painterResource(Res.drawable.logo_im),
                        contentDescription = null,
                        modifier = Modifier.height(100.dp)
                    )
                },
                onSeasonChange = { season = it },
                modifier = Modifier.offset(x = 8.dp, y = (-4).dp),
            )

            Portraits(
                senders = Sender.entries.minus(Sender.Ren).toImmutableList(),
                modifier = Modifier.weight(1f),
            )
        }

        NextButton(
            onClick = { transcriptState.advance() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .systemBarsPadding()
                .padding(16.dp)
        )
    }
}

@Composable
private fun NextButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val scale by animateFloatAsState(targetValue = if (pressed) 0.90f else 1f, label = "scale")

    Box(
        modifier = modifier
            .scale(scale)
            .clickable(
                interactionSource = interaction,
                indication = null,
                onClick = onClick,
            ),
    ) {
        Image(
            painter = painterResource(Res.drawable.next),
            contentDescription = "Next button",
        )
    }
}
