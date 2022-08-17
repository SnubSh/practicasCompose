package com.example.composeapp
import android.content.Intent
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
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.componente
import org.intellij.lang.annotations.JdkConstants

val gray = Color(	0xFFE6E6E6)
val azul = Color(	0xFF8904B1)


class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContent {
            ViewOne()
        }
    }

}

@Composable
fun ViewOne() {

   Column(
       Modifier
           .fillMaxSize()
           .padding(vertical = 30.dp, horizontal = 15.dp)
           .clip(RoundedCornerShape(30.dp))

   ) {
       Column(

           Modifier
               .padding(0.dp)
               .background(azul),


       ){

           Row(
               Modifier
                   .fillMaxWidth()
                   .size(height = 60.dp, width = 0.dp)
                   .padding(10.dp),
               horizontalArrangement = Arrangement.SpaceAround
               ) {
               ImageIcons(image = R.drawable.plus)
               textNormal(text = "Mis permisos")
               ImageIcons(image = R.drawable.mayorque)

               }
           Divider()
           Row(
               Modifier
                   .fillMaxWidth()
                   .size(height = 60.dp, width = 0.dp)
                   .padding(10.dp),
               horizontalArrangement = Arrangement.SpaceAround
           ) {
               ImageIcons(image = R.drawable.pencil)
               textNormal(text = "Mis actividades")
               ImageIcons(image = R.drawable.mayorque)

           }
           Divider()
           Row(
               Modifier
                   .fillMaxWidth()
                   .size(height = 60.dp, width = 0.dp)
                   .padding(10.dp),
               horizontalArrangement = Arrangement.SpaceAround
           ) {
               ImageIcons(image = R.drawable.download)
               textNormal(text = "Mis calificaciones")
               ImageIcons(image = R.drawable.mayorque)


           }
           Divider()

       }
       Spacer(Modifier.size(height = 20.dp, width = 10.dp))
       Row(
           Modifier.clip(RoundedCornerShape(20.dp))
       ) {
           Column(

           ) {
               Row(
                   Modifier
                       .background(azul)
                       .fillMaxWidth()
                       .padding(10.dp),
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   ImageStart(image = R.drawable.asuka)
                   Spacer(Modifier.size(height = 10.dp, width = 10.dp))
                   Column() {
                       textTitle(text = "Gina Laurence")
                       textNormal(text = "De catorce años de edad, nacida el 4 de diciembre de 2001")
                   }
               }
               Row(
                   Modifier
                       .background(azul)
                       .fillMaxWidth()
                       .padding(10.dp),
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   ImageStart(image = R.drawable.rei)
                   Spacer(Modifier.size(height = 10.dp, width = 10.dp))
                   Column() {
                       textTitle(text = "Rei Ayanami")
                       textNormal(text = "Rei Ayanami es una enigmática figura cuyo inusual comportamiento confunde a sus compañeros.")
                   }
               }
           }

       }

   }
}
@Composable
fun textName(text:String){
    Text(text = text,
        color = Color.White,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun textDescription(text:String){
    Text(
        text = text,
        color = Color.White,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Justify
    )
}
@Composable
fun textTitle(text:String){
    Text(text = text,
        color = Color.White,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun textNormal(text:String){
    Text(text = text,
        color = Color.White,
        fontSize = 20.sp

    )
}
@Composable
fun ImageStart(@DrawableRes image:Int){
    Image(
        painterResource(image),
        "back",
        Modifier
            .clip(RoundedCornerShape(30.dp))
            .size(40.dp)

    )
}
@Composable
fun ImageIcons(@DrawableRes image:Int){
    Image(
        painterResource(image),
        "back",
        Modifier.size(30.dp)



    )
}
@Composable
fun BottomNavigator(){
    val context = LocalContext.current
    Button(
        onClick = {
            //Obtener el context
            val new_page = Intent(context,MainActivity2::class.java)
            context.startActivity(new_page)
        },
        Modifier
            .size(width = 200.dp, height = 50.dp)
            .clip(RoundedCornerShape(20.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = azul)
    ) {
        Text(text = "Next Page", color = Color.White)
    }
}
@Preview(showSystemUi= true)
@Composable
fun Preview() {
    ViewOne()
}







