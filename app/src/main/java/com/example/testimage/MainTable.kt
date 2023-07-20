@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.testimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ImageTable() {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .padding(4.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        ) {
        Row {
            Column {
                Image(
                    painter = painterResource(id = R.drawable.table1),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(
                            start = 20.dp,
                            top = 32.dp
                        )
                        .height(30.dp)
                        .width(120.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.table2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(
                            start = 21.dp
                        )
                        .width(50.dp)
                        .height(40.dp)
                )
            }
            PlacementText()
        }
        Image(
            painter = painterResource(id = R.drawable.mainstuff),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    start = 28.dp,
                    top = 2.dp
                )
                .height(420.dp)
                .width(320.dp),

        )
        MainAttributes()
    }
}

@Composable
fun PlacementText() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 24.dp,
                end = 24.dp
            ),
        horizontalAlignment = Alignment.End) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(

                )
                .height(68.dp)
        ) {
            Text(
                style = TextStyle(background = Color.Blue),
                color = Color.White,
                fontSize = 50.sp,
                text = "1"
            )
            Text(
                style = TextStyle(background = Color.Red),
                color = Color.White,
                fontSize = 50.sp,
                text = "24"
            )
        }
    }
}

@Composable
fun MainAttributes() {
    var textArticule by rememberSaveable { mutableStateOf("") }
    var textSales by rememberSaveable { mutableStateOf("") }
    var textDisplay by rememberSaveable { mutableStateOf("") }
    var textPlacement by rememberSaveable { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontFamily = Monospace,
                color = Color.Black,
                fontSize = 20.sp,
                text = "Артикул: "
            )
            OutlinedTextField(
                value = textArticule,
                onValueChange = { textArticule = it },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                readOnly = true
            )
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontFamily = Monospace,
                color = Color.Black,
                fontSize = 20.sp,
                text = "Продажи: "
            )
            OutlinedTextField(
                value = textSales,
                onValueChange = { textSales = it },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                readOnly = true
            )
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontFamily = Monospace,
                color = Color.Black,
                fontSize = 20.sp,
                text = "Дисплей: "
            )
            OutlinedTextField(
                value = textDisplay,
                onValueChange = { textDisplay = it },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            )
        }
        Row(modifier = Modifier.padding(vertical = 5.dp)) {
            Text(
                modifier = Modifier.padding(8.dp),
                fontFamily = Monospace,
                color = Color.Black,
                fontSize = 20.sp,
                text = "Размещение: "
            )
            OutlinedTextField(
                value = textPlacement,
                onValueChange = { textPlacement = it },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth(),
                maxLines = 2
            )
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    ImageTable()
}