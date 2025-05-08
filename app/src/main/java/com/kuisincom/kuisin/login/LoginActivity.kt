package com.kuisincom.kuisin.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuisincom.kuisin.R
import com.kuisincom.kuisin.ui.theme.KuisinTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KuisinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

val KuisinOrange = Color(0xFFE67E22)
val KuisinOrangeLight = Color(0xFFF39C12)
val KuisinBackgroundColor = Color(0xFFFFF8F0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isStudent by remember { mutableStateOf(true) }
    val focusManager = LocalFocusManager.current
    var isLoginEnabled by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }

    isLoginEnabled = email.isNotEmpty() && password.isNotEmpty()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        KuisinBackgroundColor,
                        Color.White
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .offset((-50).dp, (-50).dp)
                .background(
                    KuisinOrangeLight.copy(alpha = 0.1f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(250.dp)
                .align(Alignment.BottomEnd)
                .offset(y = 80.dp, x = 70.dp)
                .background(
                    KuisinOrangeLight.copy(alpha = 0.1f),
                    shape = CircleShape
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(1000)) +
                        slideInVertically(
                            initialOffsetY = { -200 },
                            animationSpec = tween(1000)
                        )
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .shadow(8.dp, shape = CircleShape)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kuisin_logo),
                            contentDescription = "Kuisin Logo",
                            modifier = Modifier
                                .size(100.dp)
                                .padding(8.dp),
                            contentScale = ContentScale.Fit
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Kuisin!",
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = KuisinOrange
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Platform Kuis Interaktif untuk Pendidikan",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(24.dp),
                        spotColor = KuisinOrange.copy(alpha = 0.1f)
                    ),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(50.dp))
                            .background(Color.LightGray.copy(alpha = 0.2f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            UserTypeButton(
                                text = "Mahasiswa",
                                isSelected = isStudent,
                                onClick = { isStudent = true }
                            )
                            UserTypeButton(
                                text = "Dosen",
                                isSelected = !isStudent,
                                onClick = { isStudent = false }
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = "Email Icon",
                                tint = KuisinOrange
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        colors =  OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = KuisinOrange,
                            unfocusedBorderColor = Color.LightGray,
                            focusedLabelColor = KuisinOrange,
                            cursorColor = KuisinOrange
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password Icon",
                                tint = KuisinOrange
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        colors =  OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = KuisinOrange,
                            unfocusedBorderColor = Color.LightGray,
                            focusedLabelColor = KuisinOrange,
                            cursorColor = KuisinOrange
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                    tint = KuisinOrange
                                )
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Box(modifier = Modifier.fillMaxWidth()) {
                        TextButton(
                            onClick = { /* Handle forgot password */ },
                            modifier = Modifier.align(Alignment.CenterEnd),
                            colors = ButtonDefaults.textButtonColors(contentColor = KuisinOrange)
                        ) {
                            Text(
                                "Lupa Password?",
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = {
                            if (isLoginEnabled) {
                                // Implement login logic
                            } else {
                                showError = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = KuisinOrange,
                            contentColor = Color.White,
                            disabledContainerColor = KuisinOrange.copy(alpha = 0.5f)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp,
                            pressedElevation = 2.dp
                        ),
                        enabled = isLoginEnabled
                    ) {
                        Text("Masuk", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }

                    AnimatedVisibility(visible = showError) {
                        Text(
                            text = "Email atau password tidak boleh kosong",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(top = 8.dp),
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Belum punya akun? ",
                    color = Color.Gray
                )
                TextButton(
                    onClick = { /* Handle registration */ },
                    colors = ButtonDefaults.textButtonColors(contentColor = KuisinOrange)
                ) {
                    Text(
                        "Daftar",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserTypeButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp),
        shape = RoundedCornerShape(50.dp),
        color = if (isSelected) KuisinOrange else Color.Transparent
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.DarkGray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    KuisinTheme {
        LoginScreen()
    }
}