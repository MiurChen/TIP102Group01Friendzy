package com.pandaways.chatz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.tip102group01friendzy.MainViewModel
import com.example.tip102group01friendzy.ui.ChatScreen
import com.example.tip102group01friendzy.ui.model.ChatUiModel
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val conversation = viewModel.conversation.collectAsState()

            TIP102Group01FriendzyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChatScreen(
                        model = ChatUiModel(
                            messages = conversation.value,
                            addressee = ChatUiModel.Author.bot
                        ),
                        onSendChatClickListener = { msg -> viewModel.sendChat(msg) },
                        modifier = Modifier
                    )
                }
            }
        }
    }
}