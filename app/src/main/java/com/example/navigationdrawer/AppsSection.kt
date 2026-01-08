package com.example.navigationdrawer


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppsSection(
    items: List<MenuItem>,
    expanded: Boolean,
    onToggle: () -> Unit
) {
    val displayItems = if (expanded) items else items.take(4)

    MenuGrid(items = displayItems)

    TextButton(
        onClick = onToggle,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(if (expanded) "See Less" else "See More")
    }
}
