package com.example.tip102group01friendzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TIP102Group01FriendzyTheme {
                Main()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TIP102Group01FriendzyTheme {
        Main()
    }
}