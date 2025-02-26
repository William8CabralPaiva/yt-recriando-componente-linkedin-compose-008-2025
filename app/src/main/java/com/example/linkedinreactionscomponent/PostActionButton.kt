package com.example.linkedinreactionscomponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.linkedinreactionscomponent.ui.theme.LinkedInReactionsComponentTheme

@Composable
fun PostActionButton(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp),
            colorFilter = ColorFilter.tint(Color.Black)
        )

        Text(
            text = text,
            color = Color.Black,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PostActionButtonPreview() {
    LinkedInReactionsComponentTheme {
        PostActionButton(
            icon = R.drawable.ic_reaction_like,
            text = "Like"
        )
    }
}