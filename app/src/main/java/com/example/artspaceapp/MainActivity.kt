package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RenderArt()
                }
            }
        }
    }
}

@Composable
fun ControlArtDisplay(){
    RenderArt()
}
@Composable
fun RenderArt() {
    var currentStep by remember { mutableStateOf(1) }
    val artistList = stringArrayResource(R.array.listOfAuthor)
    val titleList = stringArrayResource(R.array.listOfTitle)
    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center,
    ){
        Row(modifier = Modifier
            .weight(0.8f)
            .padding(25.dp)

            .wrapContentSize()
            .border(
                BorderStroke(5.dp, Color.Gray),
                shape = RoundedCornerShape(4.dp),
            )
            .shadow(shape = RectangleShape, elevation = 5.dp)

        ){
            when(currentStep){
                1-> {
                    Image(
                        painter = painterResource(R.drawable.pueblachurch),
                        contentDescription = "description",
                        modifier = Modifier.padding(25.dp))
                }
                2-> {
                    Image(
                        painter = painterResource(R.drawable.pueblamarket),
                        contentDescription = "description",
                        modifier = Modifier.padding(25.dp))
                }
                3-> {
                    Image(
                        painter = painterResource(R.drawable.nightclub),
                        contentDescription = "description",
                        modifier = Modifier.padding(25.dp))
                }
                4-> {
                    Image(
                        painter = painterResource(R.drawable.sanponchocolor),
                        contentDescription = "description",
                        modifier = Modifier.padding(25.dp))
                }
                5->   Image(painter = painterResource(R.drawable.sanponchosunset), contentDescription ="description", modifier = Modifier.padding(25.dp)

                )
            }

        }
        Row(
            Modifier
                .weight(0.2f)
                .fillMaxSize()
                .padding(20.dp)
                .wrapContentSize()
                .shadow(shape = RectangleShape, elevation = 5.dp)

        ){
            when(currentStep){
                1-> {
                    Column {
                        Text(text = titleList[0],
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 9.dp, top = 9.dp, end = 9.dp),
                            fontSize = 25.sp,
                            maxLines = 2,

                            )
                        Text(text = artistList[0],
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 9.dp),
                            fontSize = 17.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold )
                    }
                }
                2-> {
                    Column {

                        Text(text = titleList[1],
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 9.dp, top = 9.dp, end = 9.dp),
                            fontSize = 25.sp,
                            maxLines = 2,

                            )
                        Text(text = artistList[1],
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 9.dp),
                            fontSize = 17.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold )
                    }
                }
                3-> {
                    Column {

                        Text(text = titleList[2],
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 9.dp, top = 9.dp, end = 9.dp),
                            fontSize = 25.sp,
                            maxLines = 2,

                            )
                        Text(text = artistList[2],
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 9.dp),
                            fontSize = 17.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold )
                    }
                }
                4-> {
                    Column {

                        Text(text = titleList[3],
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 9.dp, top = 9.dp, end = 9.dp),
                            fontSize = 25.sp,
                            maxLines = 2,

                            )
                        Text(text = artistList[3],
                            modifier = Modifier
                                .align(Alignment.Start)
                                .padding(start = 9.dp),
                            fontSize = 17.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold )
                    }
                }
                5->    Column {

                    Text(text = titleList[4],
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 9.dp, top = 9.dp, end = 9.dp),
                        fontSize = 25.sp,
                        maxLines = 2,

                        )
                    Text(text = artistList[4],
                        modifier = Modifier
                            .align(Alignment.Start)
                            .padding(start = 9.dp),
                        fontSize = 17.sp,
                        maxLines = 1,
                        fontWeight = FontWeight.Bold )
                }


            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.weight(0.1f)){
            Column(){
                Button(onClick = {if(currentStep > 1){currentStep--}else {currentStep = 5}},modifier= Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp, 50.dp) ){
                    Text(text = "Previous")
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(start = 10.dp)){
                Button(onClick = {if(currentStep < 5){currentStep++}else {currentStep = 1}},modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(150.dp, 50.dp)){
                    Text(text = "Next")
                }
            }


        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        RenderArt()
    }
}