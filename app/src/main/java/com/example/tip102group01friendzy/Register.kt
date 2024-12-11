package com.example.tip102group01friendzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.StartOffsetType
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TIP102Group01FriendzyTheme {
//                Register()
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun Register() {
//    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//    val scope = rememberCoroutineScope(

//    Scaffold(
//        topBar = {
//            TopAppBar(
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = colorResource(R.color.purple_200),
//                    titleContentColor = colorResource(R.color.Gray),
//                ),
//                title = {
//                    Text(text = "註冊")
//                }
//            )
//        },
//        modifier = TODO(),
//        bottomBar = TODO(),
//        snackbarHost = TODO(),
//        floatingActionButton = TODO(),
//        floatingActionButtonPosition = TODO(),
//        containerColor = TODO(),
//        contentColor = TODO(),
//        contentWindowInsets = TODO(),
//        content = TODO()
//    )

//    @Preview(showBackground = true)
//    @Composable
//    fun RegisterPreview() {
//        TIP102Group01FriendzyTheme {
//            Register()
//        }
//    }