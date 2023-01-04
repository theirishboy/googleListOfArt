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
fun RenderImage(imageID : Int){
    Image(
        painter = painterResource(imageID),
        contentDescription = "description",
        modifier = Modifier.padding(25.dp))


}
@Composable
fun RenderTitle(title : String){
    Text(text = title,
        modifier = Modifier
            .padding(start = 9.dp, top = 9.dp, end = 9.dp),
        fontSize = 25.sp,
        maxLines = 2,

        )
}
@Composable
fun RenderArtist(artist : String){
    Text(text = artist,
        modifier = Modifier
            .padding(start = 9.dp),
        fontSize = 17.sp,
        maxLines = 1,
        fontWeight = FontWeight.Bold )
}

@Composable
fun RenderButton(onclick : () -> Unit, text : String, modifier : Modifier) {
    Button(onClick = onclick,modifier = modifier
        .size(150.dp, 50.dp)){
        Text(text = text)
    }

}
@Composable
fun RenderArt() {
    var currentStep by remember { mutableStateOf(0) }
    val artistList = stringArrayResource(R.array.listOfAuthor)
    val titleList = stringArrayResource(R.array.listOfTitle)
    val max = titleList.size
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
                0-> {
                    RenderImage(imageID = R.drawable.pueblachurch)
                }
                1-> {
                    RenderImage(imageID = R.drawable.pueblamarket)
                }
                2-> {
                    RenderImage(imageID = R.drawable.nightclub)
                }
                3-> {
                    RenderImage(imageID = R.drawable.sanponchocolor)
                }
                4-> RenderImage(imageID = R.drawable.sanponchosunset)
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
                in 0..max->{RenderDescription(titleList[currentStep],artistList[currentStep])}

            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.weight(0.1f)){
            Column(){
               RenderButton(onclick = {if(currentStep > 0){currentStep--}else {currentStep = 4}}, text = "Previous", Modifier.align(Alignment.CenterHorizontally))
            }
            Spacer(modifier = Modifier.height(20.dp))

            Column(modifier = Modifier.padding(start = 10.dp)){
                RenderButton(onclick = {if(currentStep < 4){currentStep++}else {currentStep = 0}}, text = "Next", Modifier.align(Alignment.CenterHorizontally)
                )
            }


        }

    }
}

@Composable
fun RenderDescription(title: String, artist: String) {
    Column {
        RenderTitle(title = title)
        RenderArtist(artist)

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        RenderArt()
    }
}
