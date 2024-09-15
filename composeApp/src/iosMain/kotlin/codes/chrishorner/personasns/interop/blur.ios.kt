package codes.chrishorner.personasns.interop

import androidx.compose.ui.graphics.Paint
import org.jetbrains.skia.FilterBlurMode
import org.jetbrains.skia.MaskFilter

// Skia / Skiko-based blur implementation interprets radius differently than Android's BlurMaskFilter.
// Therefore, radius is adjusted with the difference (2r v r in final interpretation).
// Originally used 4dp as 2r on BlurMaskFilter. Therefore r = 2dp
internal actual fun Paint.setBlurMask(radius: Float) {
    asFrameworkPaint().maskFilter = MaskFilter.makeBlur(FilterBlurMode.NORMAL, radius / 2, true)
}