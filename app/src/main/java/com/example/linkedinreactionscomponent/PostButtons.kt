package com.example.linkedinreactionscomponent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.linkedinreactionscomponent.ui.theme.LinkedInReactionsComponentTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {

        var showReactPopUp by remember { mutableStateOf(false) }
        var postPositionLikeButton by remember { mutableStateOf(Offset.Zero) }
        val density = LocalDensity.current
        val offsetY = with(density){
            postPositionLikeButton.y  - 90.dp.toPx()
        }

        if (showReactPopUp) {
            Popup(
                onDismissRequest = { showReactPopUp = false }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.1f))
                        .clickable {
                            showReactPopUp = false
                        }
                )
                Surface(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = Color.White,
                    shadowElevation = 3.dp,
                    modifier = Modifier.offset {
                        IntOffset(
                            x = postPositionLikeButton.x.toInt(),
                            y = offsetY.toInt()
                        )
                    }
                ) {
                    Row {
                        listOf(
                            R.drawable.ic_reaction_like,
                            R.drawable.ic_reaction_celebrate,
                            R.drawable.ic_reaction_support,
                            R.drawable.ic_reaction_love,
                            R.drawable.ic_reaction_insightful,
                            R.drawable.ic_reaction_funny,
                        ).forEach{ iconResId ->
                            Surface(
                                onClick = {},
                                shape = CircleShape,
                                color = Color.LightGray
                            ) {
                                Image(
                                    painter = painterResource(iconResId),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .padding(6.dp)
                                )
                            }

                        }
                    }
                }
            }
        }

        PostActionButton(
            icon = R.drawable.ic_reaction_like,
            text = "Like",
            modifier = Modifier
                .weight(1f)
                .onGloballyPositioned {
                    postPositionLikeButton = it.positionInWindow()
                }
                .combinedClickable(
                    onClick = {

                    },
                    onLongClick = {
                        showReactPopUp = true
                    }
                )
        )

        PostActionButton(
            icon = R.drawable.ic_comment,
            text = "Comment",
            modifier = Modifier.weight(1f)
        )

        PostActionButton(
            icon = R.drawable.ic_share,
            text = "Share",
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ReactionButtonsPreview() {
    LinkedInReactionsComponentTheme {
        PostButtons()
    }
}