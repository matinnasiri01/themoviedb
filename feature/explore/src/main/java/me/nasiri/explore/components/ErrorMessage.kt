package me.nasiri.explore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun ErrorMessage(
    message: String?,
    modifier: Modifier = Modifier,
    grColor: Color = MaterialTheme.colorScheme.error,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(6.dp)
            .background(Color.Yellow, RoundedCornerShape(12.dp))
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, grColor, RoundedCornerShape(12.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Warning,
            contentDescription = null,
            tint = grColor
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            color = grColor,
            text = message!!,
            maxLines = 1,
            fontWeight = FontWeight.Bold
        )
    }
}