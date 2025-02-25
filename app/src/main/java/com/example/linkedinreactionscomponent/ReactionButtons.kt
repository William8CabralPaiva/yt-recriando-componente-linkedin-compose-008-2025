package com.example.linkedinreactionscomponent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.linkedinreactionscomponent.ui.theme.LinkedInReactionsComponentTheme

@Composable
fun ReactionButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        postActions.forEach {
            ReactionButton(
                icon = it.icon,
                text = it.text,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReactionButtonsPreview() {
    LinkedInReactionsComponentTheme {
        ReactionButtons()
    }
}