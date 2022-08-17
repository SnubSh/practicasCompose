package com.example.composeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Scroller
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.ui.theme.ComposeAppTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        ViewTwo()
    }
}
@Composable
fun ViewTwo(){
    Column(
        Modifier
            .background(gray)
            .fillMaxSize()
            .padding(20.dp),

    ) {
        Row(
            Modifier.clip(RoundedCornerShape(10.dp))
        ) {
            Row(
                Modifier
                    .background(azul)
                    .fillMaxWidth()
                    .clip(CircleShape),
                horizontalArrangement = Arrangement.Center
            ) {
                textTitle(text = "Characters")
            }
        }
        Spacer(Modifier.size(height = 10.dp, width = 10.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            BoxPerson(
                image = R.drawable.asuka,
                "Asuka Langley",
                "De catorce años de edad, nacida el 4 de diciembre de 20012 con nacionalidad estadounidense pero criada en Alemania lugar de fabricación de la unidad 02 antes de ser enviada a Japón. Su lengua primaria es el alemán.",
                3)
            BoxPerson(
                image = R.drawable.rei,
                "Rei Ayanami",
                "Rei Ayanami es una enigmática figura cuyo inusual comportamiento confunde a sus compañeros. A medida que avanza la trama de la serie, comienza a verse más relacionada con la gente que la rodea, particularmente con su compañero de clase y piloto de Eva, Shinji Ikari.",
                5)

        }
        Spacer(Modifier.size(20.dp))
        Row (
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            BottomNavigator()
        }
            
    }
}
@Composable
fun BoxPerson(@DrawableRes image:Int, name:String,description:String,rank: Int){

    Box(
        Modifier.clip(RoundedCornerShape(20.dp))
    ) {
        Box(
            Modifier
                .size(width = 150.dp, height = 400.dp)
                .background(azul)
                .padding(10.dp),
            contentAlignment = Alignment.Center

        ) {

            Box() {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(vertical = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,


                    ) {
                    textName(text = name)
                    Spacer(Modifier.size(10.dp))
                    ImagesPersons(image)
                    rowStars(rank = rank)
                    Spacer(Modifier.size(10.dp))
                    textDescription(text = description)
                    Spacer(Modifier.size(10.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        ImagesIcons(image = R.drawable.pencil)
                        ImagesIcons(image = R.drawable.download)
                    }
                }
            }
        }

    }
}
@Composable
fun rowStars(rank:Int){
    Row() {
        if (rank == 3){
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramgray), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramgray), contentDescription = "starts")

        }
        else {
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")
            Image(painterResource(id = R.drawable.hexagramyellow), contentDescription = "starts")

        }
    }
}
@Composable
fun ImagesPersons(@DrawableRes image:Int){
    Image(
         painterResource(image),
        "persons",
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .size(width = 100.dp, height = 100.dp)
            .shadow(elevation = 30.dp, shape = AbsoluteCutCornerShape(0.dp))
        )
}
    @Composable
    fun ImagesIcons(@DrawableRes image:Int){
        Image(
            painterResource(image),
            "icons",
            Modifier.size(30.dp)

        )
    }
    @Composable
    fun BottomNavigator(){
        val context = LocalContext.current
        Button(
            onClick = {
                //Obtener el context
                val new_page = Intent(context,MainActivity::class.java)
                context.startActivity(new_page)
            },
            Modifier
                .size(width = 200.dp, height = 50.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = azul)
        ) {
            Text(text = "Return", color = Color.White)
        }
    }
@Preview()
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
            ViewTwo()
        }
    }
}