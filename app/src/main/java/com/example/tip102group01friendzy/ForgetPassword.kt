package com.example.tip102group01friendzy

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme

@Composable
fun ForgetPassword() {
    var email by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp,40.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .clickable {  } //回到登入頁
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 200.dp)
        ) {
            Text(
                text = stringResource(R.string.ForgotYourPassword),
                fontSize = 25.sp,
                modifier = Modifier
                    .padding(12.dp)
            )

            Text(
                text = stringResource(R.string.sendLink),
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(12.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = stringResource(R.string.email)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "email"
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = colorResource(R.color.teal_700),
                    unfocusedIndicatorColor = colorResource(R.color.purple_200)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .background(colorResource(R.color.purple_200))
            )
            Button(
                onClick = {},//發送郵件
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.purple_200),
                    contentColor = Color.DarkGray)
            ) {
                Text(
                    text = stringResource(R.string.submit)
                )
            }

        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(R.drawable.text),
                contentDescription = "bottom",
                modifier = Modifier
                    .size(200.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ForgetPasswordPreview() {
    TIP102Group01FriendzyTheme {
        ForgetPassword()
    }
}