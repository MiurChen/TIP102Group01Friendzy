package com.example.tip102group01friendzy

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme

@Composable
fun Login() {
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 64.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.friendzy),
                contentDescription = "image",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(BorderStroke(1.dp, Color(0x3C645959)), CircleShape),
                contentScale = ContentScale.Crop
            )
            TextField(
                value = account,
                onValueChange = { account = it },
                label = { Text(text = "Account(email)") },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(R.color.teal_700),
                    unfocusedIndicatorColor = colorResource(R.color.purple_200)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(12.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password"
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "clear",
                        modifier = Modifier.clickable {
                            password = ""
                        }
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(R.color.teal_700),
                    unfocusedIndicatorColor = colorResource(R.color.purple_200)
                ),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(12.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            ) {
                TextButton(
                    onClick = { password = "" } //跳轉畫面到忘記密碼頁
                ) {
                    Text(
                        text = "忘記密碼",
                        color = colorResource(R.color.Gray)
                    )
                }
//                VerticalDivider(color = colorResource(R.color.Gray))
                TextButton(
                    onClick = { } //跳轉畫面到註冊
                ) {
                    Text(
                        text = "註冊",
                        color = colorResource(R.color.Gray)
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.purple_200),
                        contentColor = Color.DarkGray
                    )
                ) {
                    Text(
                        text = "登入"
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    TIP102Group01FriendzyTheme {
        Login()
    }
}