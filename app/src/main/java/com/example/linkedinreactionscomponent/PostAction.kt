package com.example.linkedinreactionscomponent

data class PostAction(
    val icon: Int,
    val text: String,
)

val postActions = listOf(
    PostAction(
        icon = R.drawable.ic_reaction_like,
        text = "Like"
    ),
    PostAction(
        icon = R.drawable.ic_comment,
        text = "Comment"
    ),
    PostAction(
        icon = R.drawable.ic_share,
        text = "Share",
    )
)