package com.kuisincom.kuisin.dosen.dashboard

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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Assignment
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuisincom.kuisin.ui.theme.KuisinTheme

// Define colors similar to LoginActivity
val KuisinOrange = Color(0xFFE67E22)
val KuisinOrangeLight = Color(0xFFF39C12)
val KuisinBackgroundColor = Color(0xFFFFF8F0)

class DosenDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KuisinTheme {
                DashboardScreen(
                    onUploadClick = {
                        // Will implement when UploadMaterialsActivity is created
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onUploadClick: () -> Unit = {}
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val dosenName = "Prof. Dr. Joshua Palti"

    var showContent by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        showContent = true
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = KuisinBackgroundColor,
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
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
            // Header section
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { -100 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
                            )
                ) {
                    Column {
                        Spacer(modifier = Modifier.height(8.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            // Profile picture
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .shadow(4.dp, shape = CircleShape)
                                    .clip(CircleShape)
                                    .background(Color.White),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = dosenName.split(" ").take(2).mapNotNull { it.firstOrNull()?.toString() }.joinToString(""),
                                    color = KuisinOrange,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Column {
                                Text(
                                    text = "Selamat Datang,",
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                                Text(
                                    text = dosenName,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.DarkGray
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))
                    }
                }
            }

            // Quick action buttons
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 100 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 4.dp,
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
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Aksi Cepat",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                QuickActionButton(
                                    icon = Icons.Default.Upload,
                                    text = "Upload\nMateri",
                                    onClick = onUploadClick
                                )
                                QuickActionButton(
                                    icon = Icons.Default.Add,
                                    text = "Buat\nKuis",
                                    onClick = { /* TODO: Create quiz */ }
                                )
                                QuickActionButton(
                                    icon = Icons.Default.Assessment,
                                    text = "Lihat\nNilai",
                                    onClick = { /* TODO: View grades */ }
                                )
                                QuickActionButton(
                                    icon = Icons.Default.Share,
                                    text = "Bagikan\nKuis",
                                    onClick = { /* TODO: Share quiz */ }
                                )
                            }
                        }
                    }
                }
            }

            // Recent classes
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 200 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Kelas Terkini",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )

                        TextButton(
                            onClick = { /* TODO: View all classes */ },
                            colors = ButtonDefaults.textButtonColors(contentColor = KuisinOrange)
                        ) {
                            Text(
                                text = "Lihat Semua",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Class cards
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 300 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        items(mockClasses) { classItem ->
                            ClassCard(classItem = classItem)
                        }
                    }
                }
            }

            // Recent quizzes section
            item {
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 400 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Kuis Terakhir",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )

                        TextButton(
                            onClick = { /* TODO: View all quizzes */ },
                            colors = ButtonDefaults.textButtonColors(contentColor = KuisinOrange)
                        ) {
                            Text(
                                text = "Lihat Semua",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            // Quiz items
            items(mockQuizzes) { quiz ->
                AnimatedVisibility(
                    visible = showContent,
                    enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)) +
                            slideInVertically(
                                initialOffsetY = { 500 },
                                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow)
                            )
                ) {
                    QuizItem(quiz = quiz)
                }
            }

            // Bottom spacing
            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun QuickActionButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .shadow(4.dp, CircleShape)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(KuisinOrange, KuisinOrangeLight)
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = Color.DarkGray,
            lineHeight = 14.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClassCard(classItem: ClassItem) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = KuisinOrange.copy(alpha = 0.1f)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = { /* TODO: Open class detail */ }
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // Class code label
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(KuisinOrange.copy(alpha = 0.1f))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = classItem.code,
                    color = KuisinOrange,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Class name
            Text(
                text = classItem.name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Student count
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Students",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${classItem.studentCount} Mahasiswa",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizItem(quiz: QuizItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(16.dp),
                spotColor = KuisinOrange.copy(alpha = 0.1f)
            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = { /* TODO: Open quiz detail */ }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        when (quiz.type) {
                            "Pilihan Ganda" -> KuisinOrange.copy(alpha = 0.1f)
                            "Esai" -> KuisinOrangeLight.copy(alpha = 0.1f)
                            else -> Color.LightGray.copy(alpha = 0.5f)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (quiz.type) {
                        "Pilihan Ganda" -> Icons.Default.CheckCircle
                        "Esai" -> Icons.Default.Edit
                        else -> Icons.Default.Assessment
                    },
                    contentDescription = quiz.type,
                    tint = when (quiz.type) {
                        "Pilihan Ganda" -> KuisinOrange
                        "Esai" -> KuisinOrangeLight
                        else -> Color.Gray
                    },
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

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

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = quiz.className,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .size(4.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = quiz.type,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Participants",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = "${quiz.participants} Peserta",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Date",
                        tint = Color.Gray,
                        modifier = Modifier.size(14.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = quiz.date,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            // Status indicator
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(
                        when (quiz.status) {
                            "Aktif" -> Color(0xFF4CAF50).copy(alpha = 0.1f)
                            "Selesai" -> Color(0xFF2196F3).copy(alpha = 0.1f)
                            else -> Color.LightGray.copy(alpha = 0.5f)
                        }
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = quiz.status,
                    color = when (quiz.status) {
                        "Aktif" -> Color(0xFF4CAF50)
                        "Selesai" -> Color(0xFF2196F3)
                        else -> Color.Gray
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

// Sample data models
data class ClassItem(
    val id: String,
    val code: String,
    val name: String,
    val studentCount: Int
)

data class QuizItem(
    val id: String,
    val title: String,
    val className: String,
    val type: String, // "Pilihan Ganda" or "Esai"
    val participants: Int,
    val date: String,
    val status: String // "Aktif" or "Selesai"
)

// Sample data
val mockClasses = listOf(
    ClassItem("1", "PAM", "Pengembangan Aplikasi Mobile", 35),
    ClassItem("2", "PBO", "Pemrograman Berorientasi Objek", 42),
    ClassItem("3", "DBA", "Database Administration", 28),
    ClassItem("4", "AI", "Artificial Intelligence", 31)
)

val mockQuizzes = listOf(
    QuizItem(
        "1",
        "UTS - Android Architecture",
        "PAM",
        "Pilihan Ganda",
        35,
        "15 Mei 2025",
        "Aktif"
    ),
    QuizItem(
        "2",
        "UTS - Database Design",
        "DBA",
        "Esai",
        28,
        "10 Mei 2025",
        "Selesai"
    ),
    QuizItem(
        "3",
        "Quiz 3 - Neural Networks",
        "AI",
        "Pilihan Ganda",
        31,
        "5 Mei 2025",
        "Selesai"
    )
)

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    KuisinTheme {
        DashboardScreen()
    }
}