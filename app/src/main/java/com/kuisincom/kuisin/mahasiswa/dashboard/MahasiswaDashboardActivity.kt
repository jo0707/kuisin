package com.kuisincom.kuisin.mahasiswa.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Assignment
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QuestionAnswer
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuisincom.kuisin.ui.theme.KuisinTheme

// Define colors similar to DosenDashboardActivity
val KuisinOrange = Color(0xFFE67E22)
val KuisinBackgroundColor = Color(0xFFFFF8F0)
val KuisinPurple = Color(0xFF9B59B6)
val KuisinGreen = Color(0xFF2ECC71)
val KuisinBlue = Color(0xFF3498DB)

class MahasiswaDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KuisinTheme {
                StudentDashboardScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDashboardScreen() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val studentName = "Josua Sinaga"

    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        showContent = true
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = KuisinBackgroundColor,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .shadow(4.dp, shape = CircleShape)
                                .clip(CircleShape)
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "K",
                                color = KuisinOrange,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Love",
                            tint = KuisinOrange,
                            modifier = Modifier.size(18.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Kuisin!",
                            color = KuisinOrange,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.weight(1f))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                actions = {
                    IconButton(onClick = { /* TODO: Notifications */ }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = KuisinOrange
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(8.dp),
                containerColor = Color.White,
                contentColor = KuisinOrange
            ) {
                // Dashboard tab
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Dashboard,
                            contentDescription = "Dashboard",
                            tint = if (selectedTab == 0) KuisinOrange else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = "Dashboard",
                            color = if (selectedTab == 0) KuisinOrange else Color.Gray,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = KuisinOrange,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )

                // Materials tab
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Book,
                            contentDescription = "Materi",
                            tint = if (selectedTab == 1) KuisinOrange else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = "Materi",
                            color = if (selectedTab == 1) KuisinOrange else Color.Gray,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = KuisinOrange,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )

                // Quizzes tab
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 },
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.Assignment,
                            contentDescription = "Kuis",
                            tint = if (selectedTab == 2) KuisinOrange else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = "Kuis",
                            color = if (selectedTab == 2) KuisinOrange else Color.Gray,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (selectedTab == 2) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = KuisinOrange,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )

                // Profile tab
                NavigationBarItem(
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Profil",
                            tint = if (selectedTab == 3) KuisinOrange else Color.Gray
                        )
                    },
                    label = {
                        Text(
                            text = "Profil",
                            color = if (selectedTab == 3) KuisinOrange else Color.Gray,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = if (selectedTab == 3) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = KuisinOrange,
                        unselectedIconColor = Color.Gray,
                        indicatorColor = Color.White
                    )
                )
            }
        }
    ) { innerPadding ->
        // Content
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Welcome message
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { -100 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                            )
                ) {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Text(
                            text = "Selamat Datang, $studentName",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            // Feature cards (2x2 grid)
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 100 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        // First row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Quiz card
                            FeatureCard(
                                title = "Kerjakan Kuis",
                                description = "Tes kemampuan Anda dan raih nilai sempurna.",
                                icon = Icons.Default.QuestionAnswer,
                                backgroundColor = KuisinBlue,
                                modifier = Modifier.weight(1f)
                            )

                            // Grades card
                            FeatureCard(
                                title = "Lihat Nilai",
                                description = "Lihat hasil pekerjaan dan kuis yang telah dikerjakan",
                                icon = Icons.Default.BarChart,
                                backgroundColor = KuisinOrange,
                                modifier = Modifier.weight(1f)
                            )
                        }

                        // Second row
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // Active quiz card
                            FeatureCard(
                                title = "Kuis Aktif",
                                description = "Lihat daftar kuis yang sedang aktif",
                                icon = Icons.Default.People,
                                backgroundColor = KuisinPurple,
                                modifier = Modifier.weight(1f)
                            )

                            // History card
                            FeatureCard(
                                title = "Histori Kuis",
                                description = "Lihat riwayat kuis dari masa lalu",
                                icon = Icons.Default.History,
                                backgroundColor = KuisinGreen,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            // Available quizzes section
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 200 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    Text(
                        text = "Kuis Tersedia",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = KuisinOrange,
                        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                    )
                }
            }

            // Available quiz items
            items(mockAvailableQuizzes) { quiz ->
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 300 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    AvailableQuizItem(quiz = quiz)
                }
            }

            // Bottom spacing
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureCard(
    title: String,
    description: String,
    icon: ImageVector,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = backgroundColor.copy(alpha = 0.2f)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor.copy(alpha = 0.1f)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(backgroundColor.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = backgroundColor,
                    modifier = Modifier.size(28.dp)
                )
            }

            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = description,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 14.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvailableQuizItem(quiz: AvailableQuiz) {
    ElevatedCard(
        onClick = { /* TODO: Open quiz */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = KuisinOrange.copy(alpha = 0.1f)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = quiz.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Dr. ${quiz.lecturer}",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(KuisinOrange.copy(alpha = 0.1f))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Participants",
                        tint = KuisinOrange,
                        modifier = Modifier.size(14.dp)
                    )

                    Text(
                        text = "${quiz.participants} peserta",
                        color = KuisinOrange,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

// Sample data model for available quizzes
data class AvailableQuiz(
    val id: String,
    val title: String,
    val lecturer: String,
    val participants: Int,
    val dueTime: String
)

// Sample data for available quizzes
val mockAvailableQuizzes = listOf(
    AvailableQuiz(
        "1",
        "Nuklir Dasar I",
        "Fakhri Nazir",
        43,
        "10:42"
    ),
    AvailableQuiz(
        "2",
        "Nuklir Dasar I",
        "Rahmi Sadar",
        42,
        "12:32"
    ),
    AvailableQuiz(
        "3",
        "Nuklir Dasar I",
        "Fakhri Nazir",
        42,
        "12:42"
    )
)

@Preview(showBackground = true)
@Composable
fun StudentDashboardScreenPreview() {
    KuisinTheme {
        StudentDashboardScreen()
    }
}