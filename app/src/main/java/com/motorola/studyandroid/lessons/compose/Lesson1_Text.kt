package com.motorola.studyandroid.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Lesson1_Text() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Basic Text
        Text(text = "Hello, Android World!")
        
        // Text with size
        Text(text = "Hello with size 24sp", fontSize = 24.sp)
        
        // Text with color
        Text(text = "Hello with Red Color", color = Color.Green)
        
        // Text with weight
        Text(text = "Hello with Bold Weight", fontWeight = FontWeight.Bold)

        // Combining modifiers
        Text(
            text = "Hello with all combined",
            fontSize = 20.sp,
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

