package com.example.testimage

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun PreviewPage(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(10L)
        navController.navigate("main_screen")
    }
    Image(
        painter = painterResource(id = R.drawable.preview1),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End
    ) {
        Image(
            painter = painterResource(id = R.drawable.preview2),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    end = 16.dp,
                    top = 16.dp
                )
                .height(70.dp)
                .width(250.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.preview3),
            contentDescription = null,
            modifier = Modifier
                .padding(
                    end = 8.dp
                )
                .height(60.dp)
                .width(230.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {
    var labelText by remember { mutableStateOf("") }
    val contextForButton = LocalContext.current.applicationContext
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {

        composable("splash_screen") {
            PreviewPage(navController = navController)
        }

        composable("main_screen") {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(300.dp)
                        .padding(10.dp),
                    painter = painterResource(id = R.drawable.preview2),
                    contentDescription = null
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(6.dp)
                ) {
                    val result = remember { mutableStateOf<Uri?>(null) }
                    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
                        result.value = it
                    }

                    OutlinedTextField(
                        value = labelText,
                        onValueChange = { labelText = it },
                        modifier = Modifier
                            .width(220.dp)
                            .height(68.dp)
                            .padding(
                                end = 8.dp,
                                bottom = 5.dp
                            ),
                        label = { Text(text = "Upload EXCEL file") }
                    )
                    FloatingActionButton(
                        modifier = Modifier
                            .size(50.dp),
                        containerColor = Color.Black,
                        contentColor = Color.White,
                        onClick = {
                            launcher.launch("application/*") //переделать * на xlsx
                        }
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(40.dp),
                            imageVector = Icons.Outlined.Search,
                            contentDescription = null
                        )
                    }
                }
                FloatingActionButton(
                    modifier = Modifier
                        .padding(15.dp)
                        .width(180.dp)
                        .height(50.dp),
                    containerColor = Color.Black,
                    contentColor = Color.White,
                    onClick = { Toast.makeText(contextForButton, "Generating Table", Toast.LENGTH_LONG)
                        .show()
                    }
                ) {
                    Text(
                        fontSize = (20.sp),
                        text = "Generate Table"
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    MainPage()
}

