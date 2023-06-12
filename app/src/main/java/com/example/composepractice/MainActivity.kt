package com.example.composepractice

import android.graphics.fonts.FontFamily
import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize

import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
@Preview
private fun ArtAppPreview() {
    ComposePracticeTheme {
        ArtSpaceApp()
    }
}

@Composable
private fun ArtSpaceApp() {

    var imageID by remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxHeight()
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.2F)
                .size(5.dp)
        )
        Surface(
            shadowElevation = 10.dp,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .weight(1.2F)
                .wrapContentSize()
                .border(1.dp, color = Color.LightGray)
        ) {
            Box(modifier = Modifier.padding(30.dp), contentAlignment = Alignment.Center) {
                when (imageID) {
                    1 -> {

                        Image(
                            painter = painterResource(id = R.drawable.first_image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )
                    }

                    2 -> {

                        Image(
                            painter = painterResource(id = R.drawable.second_image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )
                    }

                    else -> {
                        Image(
                            painter = painterResource(id = R.drawable.third_image),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )
                    }
                }

            }

        }
        Spacer(
            modifier = Modifier
                .weight(0.2F)
                .size(5.dp)
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .weight(0.5F)
                .background(color = Color.LightGray)

        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)


            ) {
                Text(
                    text = "Still Life of Blue Rose and Other Flowers", style = TextStyle(
                        color = Color.Black, fontSize = 20.sp
                    )
                )
                Row {
                    Text(
                        text = "Owen Scott", style = TextStyle(
                            color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.W800
                        )
                    )
                    Spacer(modifier = Modifier.size(2.dp))
                    Text(
                        text = "(2021)", style = TextStyle(
                            color = Color.Black,
                            fontSize = 10.sp,
                        )
                    )
                }

            }
        }
        //Spacer(modifier = Modifier.size(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2F)
        ) {
            Spacer(
                modifier = Modifier
                    .size(2.dp)
                    .weight(0.05F)
            )
            Button(
                modifier = Modifier
                    .weight(0.6F)
                    .padding(horizontal = 8.dp),
                onClick = {
                    if (imageID > 1)
                        imageID -= 1
                }
            ) {
                Text(text = "Previous")
            }
            Spacer(
                modifier = Modifier
                    .size(2.dp)
                    .weight(0.2F)
            )
            Button(
                modifier = Modifier
                    .weight(0.6F)
                    .padding(horizontal = 8.dp),
                onClick = {
                    if (imageID < 3)
                        imageID += 1
                }
            ) {
                Text(text = "Next")
            }
            Spacer(
                modifier = Modifier
                    .size(2.dp)
                    .weight(0.1F)
            )
        }
    }
}

