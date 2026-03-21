package com.motorola.studyandroid.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Lesson2_Layout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Row Example (Horizontal):")
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
        ) {
            Box(Modifier.size(60.dp).background(Color.Green)) {}
            Box(Modifier.size(40.dp).background(Color.Blue)) {}
        }

        Text("Column Example (Vertical):")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
        ) {
            Box(Modifier.size(50.dp).background(Color.Red))
            Box(Modifier.size(50.dp).background(Color.Green))
            Box(Modifier.size(50.dp).background(Color.Blue))
        }

        Text("Box Example (Stacking):")

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Box(Modifier.size(80.dp).background(Color.Red))
            Box(Modifier.size(60.dp).background(Color.Green))
            Box(Modifier.size(40.dp).background(Color.Blue))
            Text("Top", color = Color.White)
        }
    }
}

