package com.example.tip102group01friendzy

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.tip102group01friendzy.ui.theme.TIP102Group01FriendzyTheme
import kotlinx.coroutines.launch

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(
    navController: NavHostController
) {
    val context = LocalContext.current
    var account by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var status by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val emailRegex = Patterns.EMAIL_ADDRESS
    val isValidEmail = emailRegex.matcher(account).matches()
    val emailShowError = account.isNotEmpty() && !isValidEmail
    val passwordShowError = password.count() < 8


    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp, 40.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Text(
                text = stringResource(R.string.setUp),
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(6.dp)
            )
        }


        OutlinedTextField(
            value = account,
            onValueChange = { account = it },
            placeholder = { Text(text = stringResource(R.string.account)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "account"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = emailShowError,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(R.color.teal_700),
                unfocusedIndicatorColor = colorResource(R.color.purple_200),
                errorIndicatorColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp, 12.dp)
                .background(colorResource(R.color.purple_200))
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = stringResource(R.string.password)) },
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
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = passwordShowError,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(R.color.teal_700),
                unfocusedIndicatorColor = colorResource(R.color.purple_200),
                errorIndicatorColor = Color.Red
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp, 12.dp)
                .background(colorResource(R.color.purple_200))
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = { Text(text = stringResource(R.string.confirmPassword)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "confirmPassword"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "clear",
                    modifier = Modifier.clickable {
                        confirmPassword = ""
                    }
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(R.color.teal_700),
                unfocusedIndicatorColor = colorResource(R.color.purple_200)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp, 12.dp)
                .background(colorResource(R.color.purple_200))
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text(text = stringResource(R.string.name)) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "name"
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(R.color.teal_700),
                unfocusedIndicatorColor = colorResource(R.color.purple_200)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp, 12.dp)
                .background(colorResource(R.color.purple_200))
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 8.dp)
        ) {
            Box(
                contentAlignment = Alignment.TopStart,
                modifier = Modifier
                    .padding(6.dp)
                    .background(colorResource(R.color.De))
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "check",

                        )
                    Text(
                        text = "Status",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(6.dp)
                    )
                }
            }
            Text(
                text = "Accompany",
                color =
                if (!status) colorResource(R.color.blue_700)
                else colorResource(R.color.Gray),
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))


            )
            SwitchWithText(status) {
                status = it
            }
            Text(
                text = "Companion",
                color =
                if (status) colorResource(R.color.blue_700)
                else colorResource(R.color.Gray),
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
        Button(
            onClick = {
                if (passwordShowError) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = context.getString(R.string.passwordRule),
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
                } else if (password != confirmPassword) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = context.getString(R.string.passwordDifferent),
                            withDismissAction = true
                        )
                    }
                } else if (account.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || username.isEmpty()) {
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = context.getString(R.string.columnIsEmpty),
                            withDismissAction = true
                        )
                    }
                }else{
                navController.navigate(Screen.Login.name)
                }
            },//1.格線都輸入且符合規格回到登入頁
            // 2.密碼確認沒問題回到登入頁
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.purple_200),
                contentColor = Color.DarkGray
            )

        ) {
            Text(
                text = stringResource(R.string.submit)
            )
        }
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

@Composable
fun SwitchWithText(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        thumbContent =
        if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "ststus",
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = colorResource(R.color.pink_200),
            checkedTrackColor = colorResource(R.color.green_200),
            uncheckedThumbColor = colorResource(R.color.blue_700),
            uncheckedTrackColor = colorResource(R.color.green_200)
        )
    )
}


@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    TIP102Group01FriendzyTheme {
        Register(rememberNavController())
    }
}