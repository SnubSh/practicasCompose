package com.example.composeapp
import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.componente
import org.intellij.lang.annotations.JdkConstants

class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContent {
            Components()
        }
    }

}
@Composable
fun text (text:String){
    Text(text = text)
}
@Composable
fun price (text:String){
    Text(text = text, fontWeight = FontWeight.Bold, fontSize = 15.sp)
}
@Composable
fun imageObjects(@DrawableRes image: Int){
    Box(

        Modifier
            .size(
                width = 100.dp,
                height = 100.dp,
            ),
        contentAlignment = Alignment.Center


    )
    {
        Image(
            painter = painterResource(image),
            "Imagen",
            Modifier
                .size(90.dp)
                .clip(shape = CutCornerShape(2.dp))
                .background(Color.LightGray))

    }
}
@Composable
fun icons(@DrawableRes image: Int){

    Image(
        painter = painterResource(image),
        "Imagen",
        Modifier.size(10.dp),

    )

}

@Composable
fun Components() {
    Column(

    ) {
        Row(

            horizontalArrangement = Arrangement.Start
        ) {
            price(text = "MY CHART")

        }
        Box(

            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Divider()
                Spacer(Modifier.size(20.dp))
                RowComponent(R.drawable.pet, "T-Shirt Pet", "24.00")
                Spacer(Modifier.size(20.dp))
                Divider()
                Spacer(Modifier.size(20.dp))
                RowComponent(R.drawable.tshirt,"T-Shirt Flash", "20.00")
                Spacer(Modifier.size(20.dp))
                Divider()
                Spacer(Modifier.size(20.dp))
                RowComponent(R.drawable.shirt,"T-Shirt Arcoiris", "23.00")
                Spacer(Modifier.size(20.dp))
                Divider()
                Spacer(Modifier.size(20.dp))
            }

        }
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Row(
                Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                price(text = "Total")
                price(text = "$67.00")

            }
        }
    }

}
@Composable
fun RowComponent(image: Int, nombre:String, precio:String){
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        //Imagen
        imageObjects(image = image)
        Column(
            Modifier
                .padding(10.dp),
                //.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            //Nombre
            text(text = nombre)
            price(text = precio)

            Row(
                Modifier.size(width = 50.dp, height = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                icons(R.drawable.minus)
                text(text = "1")
                icons(R.drawable.plus)
            }

        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun Preview() {
    Components()
}
/*    Row(
        //horizontalArrangement = Arrangement.SpaceAround,
        //verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            Modifier
                .size(height = 250.dp, width = 500.dp)
                .background(Color.Yellow),
        ) {
            Column(
                Modifier
                    .size(height = 200.dp, width = 500.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                text(text = "Bienvenido", Color.Blue)
                text(text = "Como estas?", Color.Green)
                text(text = "Portate bien", Color.Magenta)
            }
        }
    }
}*/
/*@Composable
fun columnInitial(){
    Column(

        //Reparte el espacio entre los elementos dentro de la columna
        //verticalArrangement = Arrangement.SpaceEvenly

        //El primer y ultimo elemento no tienen espacio en los bordes y el elemento de en medio centrado
        //verticalArrangement = Arrangement.SpaceBetween

        //Permite dejar espacios arriba y abajo  en los bordes pero dejando solo a la mitad
        //verticalArrangement = Arrangement.SpaceAround,

        //Centra los elementos de la columa
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.SpaceAround


    ) {
        text(text = "Bienvenido", Color.Blue)
        text(text = "Como estas?", Color.Green)
        text(text = "Portate bien", Color.Magenta)
    }

}*/







