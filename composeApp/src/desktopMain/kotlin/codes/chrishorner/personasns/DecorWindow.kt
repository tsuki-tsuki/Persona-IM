package codes.chrishorner.personasns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowScope
import codes.chrishorner.personasns.interop.RootContainerColor
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.skiko.hostOs
import personasns.composeapp.generated.resources.Res
import personasns.composeapp.generated.resources.app_icon
import personasns.composeapp.generated.resources.app_name

internal var windowColorState by mutableStateOf(RootContainerColor(backgroundColor = Color.Gray))

@Composable
private fun closeButton(
    onClick: () -> Unit = {},
    contentColor: Color = Color.White,
) = IconButton(
    onClick = onClick,
    colors = IconButtonDefaults.iconButtonColors(contentColor = contentColor),
) {
    Icon(Icons.Default.Close, contentDescription = "Close")
}

@Composable
private fun minimizeButton(
    onClick: () -> Unit = {},
    contentColor: Color = Color.White,
) = IconButton(
    onClick = onClick,
    colors = IconButtonDefaults.iconButtonColors(contentColor = contentColor),
) {
    Icon(Icons.Default.ArrowDropDown, contentDescription = "Minimize")
}

@Composable
fun WindowScope.DecorWindow(
    modifier: Modifier = Modifier,
    onClickMinimize: () -> Unit,
    onClickClose: () -> Unit,
    content: @Composable () -> Unit,
) {
    val contentColor = contentColorFor(windowColorState.statusBarColor)
    val buttonList: List<@Composable () -> Unit> = listOf(
        @Composable { minimizeButton(onClickMinimize, contentColor) },
        @Composable { closeButton(onClickClose, contentColor) },
    )

    Box(
        modifier = modifier.fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(windowColorState.backgroundColor)
    ) {
        // TODO prevent clipping of content
        Box(modifier = Modifier.fillMaxSize().padding(top = 55.dp)) {
            content()
        }

        WindowDraggableArea(
            modifier = Modifier.fillMaxWidth().background(windowColorState.statusBarColor)
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier.align(
                    if (hostOs.isMacOS) Alignment.CenterStart
                    else Alignment.CenterEnd
                )
            ) {
                buttonList.let { if (hostOs.isMacOS) it.reversed() else it }.forEach { it() }
            }
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painterResource(Res.drawable.app_icon),
                    stringResource(Res.string.app_name),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    stringResource(Res.string.app_name),
                    fontWeight = FontWeight.Bold,
                    color = contentColor,
                )
            }
        }
    }
}
