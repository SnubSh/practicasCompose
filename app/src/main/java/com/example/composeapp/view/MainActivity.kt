package com.example.composeapp.view
import MainActivityModel
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeapp.R

//val gray = Color(	0xFFE6E6E6)
//val azul = Color(	0xFF8904B1)





class MainActivity : ComponentActivity() {
    val ovm: MainActivityModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(all = 30.dp)
                    ,
                horizontalAlignment = Alignment.CenterHorizontally,

            ) {
//                string()
//                ViewPractice()
//                ButtonDecreaseValue()
//                ButtonIncrementValueFor2()
//                ButtonIncrementFor5Value()
                imagen()
                Spacer(Modifier.height(10.dp))
                generarSpinner(ovm)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total: " + ovm.result.value.toString() +"  MXN")
                ButtonResetValue()
                }
            }
        }
    }
@Composable
fun imagen(){
    Row(
        Modifier.clip(shape = RoundedCornerShape(20.dp))
    ) {
        Image(painterResource(id = R.drawable.coin),"")

    }
}

    @Composable
    fun ViewPractice() {

        Button(onClick = { ovm.add() }) {
            Text(text = "Sumar + 1")

        }

    }

    @Composable
    fun string() {
        Text(text = "Valor es: " + ovm.counter.value.toString())


    }

    @Composable
    fun ButtonResetValue() {
        Button(onClick = { ovm.reset() }) {
            Text(text = "Reiniciar")

        }
    }

    @Composable
    fun ButtonDecreaseValue() {
        Button(onClick = { ovm.restar() }) {
            Text(text = "Restar")

        }
    }

    @Composable
    fun ButtonIncrementValueFor2() {
        Button(onClick = { ovm.sumarFor2() }) {
            Text(text = "incrementar + 2")

        }
    }

    @Composable
    fun ButtonIncrementFor5Value() {
        Button(onClick = { ovm.sumarFor5() }) {
            Text(text = "incrementar + 5")

        }
    }

//    @Composable
//    fun textFiel() {
////        var textTemp = remember {
////            mutableStateOf(0)
////        }
//
//
////        Text(text = "Value String: " + ovm.text.value.toString())
////
////        Button(onClick = { ovm.setString(textTemp.value.toString()) }) {
////            Text(text = "Obten string")
////
////        }
//
//
//
//
//    }

    @Composable
    fun generarSpinner(ovm: MainActivityModel) {

        var expanded by remember { mutableStateOf(false) }

        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Opciones")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {

                DropdownMenuItem(onClick = {
                    ovm.setLapiz()
                    ovm.setSum(ovm.lapiz.value)
                    expanded = false
                }) {
                    Text(text = "Lapiz $10")
                }
                DropdownMenuItem(onClick = {
                    ovm.setBorrador()
                    ovm.setSum(ovm.borrador.value)

                    expanded = false
                }) {
                    Text(text = "Borrador $5")
                }
                DropdownMenuItem(onClick = {
                    ovm.setLapicero()
                    ovm.setSum(ovm.lapicero.value)

                    expanded = false
                }) {
                    Text(text = "Lapicero $15")
                }
                DropdownMenuItem(onClick = {
                    ovm.setCuaderno()
                    ovm.setSum(ovm.cuaderno.value)

                    expanded = false
                }) {
                    Text(text = "Cuaderno $30")
                }
            }
        }
    }
}


    //Vista previa
//    @Preview(showSystemUi= true)
//    @Composable
//    fun Preview() {
//        ViewPractice()
//    }
















