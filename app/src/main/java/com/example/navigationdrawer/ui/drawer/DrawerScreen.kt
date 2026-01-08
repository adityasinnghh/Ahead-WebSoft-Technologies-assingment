package com.example.navigationdrawer.ui.drawer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.navigationdrawer.FeatureCard
import com.example.navigationdrawer.MenuGrid

@Composable
fun DrawerScreen(viewModel: DrawerViewModel = viewModel()) {

    val sections = viewModel.menuSections

    if (sections.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Color(0xFFF7F8FA))
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        /* ---------- TOP BAR ---------- */
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Menu", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("IND-INR-EN", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        }

        /* ---------- PROFILE CARD ---------- */
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = "https://i.pravatar.cc/150",
                        contentDescription = null,
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray),
                        contentScale = ContentScale.Crop // ✅ avoid stretching
                    )


                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        "Alex Brain",
                        modifier = Modifier.weight(1f),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text("Edit Profile", color = Color(0xFF4A90E2), fontSize = 14.sp)
                }
            }
        }

        /* ---------- MESSAGE / NOTIFICATIONS ---------- */
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FeatureCard(
                    title = "Message",
                    icon = Icons.Default.Message,
                    iconColor = Color(0xFF2196F3),
                    modifier = Modifier.weight(1f)
                )
                FeatureCard(
                    title = "Notifications",
                    icon = Icons.Default.NotificationsActive,
                    iconColor = Color(0xFFFFD700),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        /* ---------- APPS SECTION ---------- */
        item {
            Text("Apps", fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }

        item {
            MenuGrid(
                items = if (viewModel.appsExpanded)
                    sections["APPS"].orEmpty()
                else
                    sections["APPS"].orEmpty().take(4)
            )
        }

        if ((sections["APPS"]?.size ?: 0) > 4) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { viewModel.toggleApps() },
                    border = BorderStroke(1.dp, Color(0xFFE9EAEE)),
                    shape = RoundedCornerShape(2.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),

                        contentAlignment = Alignment.Center,

                    ) {
                        Text(
                            text = if (viewModel.appsExpanded) "See Less" else "See More",
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }


        /* ---------- HELP MORE SECTION (RESTORED) ---------- */
        item {
            Text(
                "Help More",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

        item {
            MenuGrid(
                items = sections["HELP & MORE"].orEmpty().take(4)
            )
        }

        /* ---------- RATE US ---------- */
        item {
            FeatureCard(
                title = "Rate Us",
                icon = Icons.Default.StarOutline,
                iconColor = Color(0xFFFFD700),
                modifier = Modifier.fillMaxWidth()
            )
        }

        /* ---------- SIGN OUT ---------- */
        item {
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(2.dp),
                border = BorderStroke(1.dp, Color.Red)
            ) {
                Text("Sign Out", color = Color.Red)
            }
        }
    }
}
