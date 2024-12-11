package com.example.tip102group01friendzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme
import kotlinx.coroutines.launch

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.yellow_100),
                    titleContentColor = colorResource(R.color.Gray)
                ),
                title = { Text(text = stringResource(R.string.SetUp)) },
                navigationIcon = {
                    IconButton(onClick = {}) { //回到登入頁
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "back"
                        )
                    }
                },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.friendzy),
                        contentDescription = "friendzy",
                        modifier = Modifier
                            .fillMaxSize(0.125f)
                            .clip(CircleShape)
                            .aspectRatio(1f)
                            .border(BorderStroke(1.dp, Color(0x3C645959)), CircleShape),
                        contentScale = ContentScale.Crop
                        )
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = colorResource(R.color.yellow_100),
                contentColor = colorResource(R.color.Gray),
                actions = {
                    IconButton(onClick = {}) { //確認資料
                        Icon(
                            Icons.Filled.Check,
                            contentDescription = "confirm"
                        )
                    }
                }
            )
        }

    ) { innerPadding ->
        scrollContent(innerPadding)
    }
}

@Composable
fun scrollContent(innerPaffing: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPaffing)
    ) {
        items(10) {
//滾動輸入文字方塊
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    TIP102Group01FriendzyTheme {
        Register()
    }
}