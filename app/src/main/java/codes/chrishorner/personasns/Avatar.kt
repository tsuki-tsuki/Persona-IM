package codes.chrishorner.personasns

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

@Composable
fun Avatar(@DrawableRes avatarImage: Int, color: Color) {
  Box(
    modifier = Modifier
      .size(Transcript.AvatarSize)
      .drawBehind {
        drawOutline(Outline(avatarBlackBox()), Color.Black)
        drawOutline(Outline(avatarWhiteBox()), Color.White)
        drawOutline(Outline(avatarColoredBox()), color)
      }
      .clip(with(LocalDensity.current) { avatarClipBox() })
  ) {
    Image(
      painter = painterResource(avatarImage),
      contentDescription = null,
      modifier = Modifier
        .size(80.dp)
        .align(Alignment.TopEnd)
    )
  }
}

private fun Density.avatarColoredBox(): Shape = GenericShape { _, _ ->
  moveTo(22.5.dp.toPx(), 28.dp.toPx())
  lineTo(94.4.dp.toPx(), 31.4.dp.toPx())
  lineTo(104.3.dp.toPx(), 67.5.dp.toPx())
  lineTo(40.dp.toPx(), 76.6.dp.toPx())
  close()
}

private fun Density.avatarWhiteBox(): Shape = GenericShape { _, _ ->
  moveTo(16.4.dp.toPx(), 20.5.dp.toPx())
  lineTo(96.7.dp.toPx(), 30.4.dp.toPx())
  lineTo(106.4.dp.toPx(), 70.dp.toPx())
  lineTo(37.8.dp.toPx(), 80.4.dp.toPx())
  close()
}

private fun Density.avatarBlackBox(): Shape = GenericShape { _, _ ->
  moveTo(0f, 17.dp.toPx())
  lineTo(100.5.dp.toPx(), 27.2.dp.toPx())
  lineTo(110.dp.toPx(), 72.7.dp.toPx())
  lineTo(33.4.dp.toPx(), 90.dp.toPx())
  close()
}

private fun Density.avatarClipBox(): Shape = GenericShape { _, _ ->
  moveTo(10.3.dp.toPx(), (-5.6).dp.toPx())
  lineTo(114.7.dp.toPx(), (-5.6).dp.toPx())
  lineTo(114.7.dp.toPx(), 65.6.dp.toPx())
  lineTo(40.dp.toPx(), 76.6.dp.toPx())
  close()
}
