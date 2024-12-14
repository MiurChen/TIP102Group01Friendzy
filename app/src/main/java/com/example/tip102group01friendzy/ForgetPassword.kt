package com.example.tip102group01friendzy

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme
import kotlinx.coroutines.launch

@Composable
fun ForgetPassword(
    navController: NavHostController
) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val emailRegex = Patterns.EMAIL_ADDRESS
    val isValidEmail = emailRegex.matcher(email).matches()
    val emailShowError = email.isNotEmpty() && !isValidEmail

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 130.dp)
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
                onValueChange = {
                    email = it
                },
                placeholder = { Text(text = stringResource(R.string.email)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.MailOutline,
                        contentDescription = "email"
                    )
                },
                singleLine = true,
                isError = !emailShowError,
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
                onClick = {
                    if (email.isEmpty()) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = context.getString(R.string.EmailCanNotEmpty),
                                withDismissAction = true
                            )
                        }
                    } else if (emailShowError) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = context.getString(R.string.errorEmail),
                                withDismissAction = true
                            )
                        }
                    }//else{}電子信箱正確且曾註冊過發送郵件
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.purple_200),
                    contentColor = Color.DarkGray
                )
            ) { Text(text = stringResource(R.string.submit)) }
            SnackbarHost(hostState = snackbarHostState)
        }
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxSize()
        ) {
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
        ForgetPassword(rememberNavController())
    }
}