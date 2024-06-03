//package me.nasiri.home.components
//
//import android.graphics.Path
//import android.graphics.PathMeasure
//import android.graphics.Rect
//import androidx.compose.animation.core.EaseOut
//import androidx.compose.animation.core.LinearEasing
//import androidx.compose.animation.core.RepeatMode
//import androidx.compose.animation.core.animateFloat
//import androidx.compose.animation.core.infiniteRepeatable
//import androidx.compose.animation.core.rememberInfiniteTransition
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.EmptyBuildDrawCacheParams.layoutDirection
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.StrokeCap
//import androidx.compose.ui.graphics.drawscope.DrawScope
//import androidx.compose.ui.graphics.drawscope.Stroke
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun BorderThing() {
//    val anim = rememberInfiniteTransition()
//    val progress = anim.animateFloat(
//        initialValue = 0f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        )
//    )
//
//    Box(
//        modifier = Modifier.padding(16.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .width(200.dp)
//                .height(50.dp)
//                .animatedBorder({ progress.value }, Color.Blue, Color.Gray/*MaterialTheme.colorScheme.outline*/)
//        )
//    }
//}
//
//fun Modifier.animatedBorder(provideProgress: () -> Float, colorFocused: Color, colorUnfocused: Color) = this.drawWithCache {
//    val width = size.width
//    val height = size.height
//
//    val shape = CircleShape
//
//    // Only works with RoundedCornerShape...
//    val outline = shape.createOutline(size, layoutDirection, this) as Outline.Rounded
//
//    // ... correction: Only works with same corner sizes everywhere
//    val radius = outline.roundRect.topLeftCornerRadius.x
//    val diameter = 2 * radius
//
//    // Clockwise path
//    val pathCw = Path()
//
//    // Start top center
//    pathCw.moveTo(width / 2, 0f)
//
//    // Line to right
//    pathCw.lineTo(width - radius, 0f)
//
//    // Top right corner
//    pathCw.arcTo(Rect(width - diameter, 0f, width, diameter), -90f, 90f, false)
//
//    // Right edge
//    pathCw.lineTo(width, height - radius)
//
//    // Bottom right corner
//    pathCw.arcTo(Rect(width - diameter, height - diameter, width, height), 0f, 90f, false)
//
//    // Line to bottom center
//    pathCw.lineTo(width / 2, height)
//
//    // As above, but mirrored horizontally
//    val pathCcw = Path()
//    pathCcw.moveTo(width / 2, 0f)
//    pathCcw.lineTo(radius, 0f)
//    pathCcw.arcTo(Rect(0f, 0f, diameter, diameter), -90f, -90f, false)
//    pathCcw.lineTo(0f, height - radius)
//    pathCcw.arcTo(Rect(0f, height - diameter, diameter, height), 180f, -90f, false)
//    pathCcw.lineTo(width / 2, height)
//
//    val pmCw = PathMeasure().apply {
//        setPath(pathCw, false)
//    }
//    val pmCcw = PathMeasure().apply {
//        setPath(pathCcw, false)
//    }
//
//    fun DrawScope.drawIndicator(progress: Float, pathMeasure: PathMeasure) {
//        val subPath = Path()
//        pathMeasure.getSegment(0f, pathMeasure.length * EaseOut.transform(progress), subPath)
//        drawPath(subPath, colorFocused, style = Stroke(3.dp.toPx(), cap = StrokeCap.Round))
//    }
//
//    onDrawBehind {
//        // Draw the shape
//        drawOutline(outline, colorUnfocused, style = Stroke(2.dp.toPx()))
//
//        // Draw the indicators
//        drawIndicator(provideProgress(), pmCw)
//        drawIndicator(provideProgress(), pmCcw)
//    }
//}