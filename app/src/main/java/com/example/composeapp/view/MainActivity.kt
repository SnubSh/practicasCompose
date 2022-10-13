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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
//                imagen()
//                Spacer(Modifier.height(10.dp))
                Text(text = "Calcular IMC")
                generarSpinner(ovm)
                //containerTexts(ovm)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Text(text = "Total: $" + ovm.result.value.toString() +"  MXN")

                }
                    textField()
                containerTexts(ovm = ovm)
                    

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
    fun containerTexts(ovm: MainActivityModel) {

        Card(
            Modifier.fillMaxWidth()
        ) {
            Column() {
                Text(text = "Su sexo es : "+ovm.sexo.value.toString())
                Text(text = "IMC : "+ ovm.imc.value.toString())
                Text(text = "Tiene : " +ovm.tiene.value.toString(), fontWeight = FontWeight.Bold)

            }

        }


    }

    @Composable
    fun string() {
        Text(text = "Valor es: " + ovm.counter.value.toString())


    }

    @Composable
    fun ButtonResetValue(peso:String,estatura:String) {
        Button(onClick =
        {
            ovm.calculateIMC(peso = peso, altura = estatura)

        }
        ) {

            Text(text = "Calcular")

        }
    }
    @Composable
    fun ButtonDescuento(value: String) {
        Button(onClick = { ovm.restar(value.toDouble()) }) {
            Text(text = "Descuento")

        }
    }

//    @Composable
//    fun ButtonDecreaseValue() {
//        Button(onClick = { ovm.restar() }) {
//            Text(text = "Restar")
//
//        }
//    }

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

    @Composable
    fun textField() {
        var _estatura = remember {
            mutableStateOf("")
        }

        var _peso = remember {
            mutableStateOf("")
        }
        Column(

            Modifier.fillMaxWidth(),
            //horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonResetValue(peso = _peso.value, estatura = _estatura.value)
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Text(text = "Estura")
                TextField(

                    value = _estatura.value, onValueChange = {
                        _estatura.value = it
                    },

                    Modifier.width(100.dp),

                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Number),
                )
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Peso KG")
                TextField(

                    value = _peso.value, onValueChange = {
                        _peso.value = it
                    },

                    Modifier.width(100.dp),

                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Number),
                )
            }
        }
        
//        Text(text = "Value String: " + ovm.text.value.toString())
//
//        Button(onClick = { ovm.setString(textTemp.value.toString()) }) {
//            Text(text = "Obten string")

        }


    @Composable
    fun generarSpinner(ovm: MainActivityModel) {

        var expanded by remember { mutableStateOf(false) }

        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Seleciona Sexo")
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
//                    ovm.addObject()
//                    ovm.setLapiz()
//                    ovm.setSum(ovm.lapiz.value)
                    ovm.setMasculino()
                    expanded = false
                }) {
                    Text(text = "Masculino")
                }
                DropdownMenuItem(onClick = {
//                    ovm.addObject()
//                    ovm.setBorrador()
//                    ovm.setSum(ovm.borrador.value)
                    ovm.setFemenino()

                    expanded = false
                }) {
                    Text(text = "Femenino")
                }
//                DropdownMenuItem(onClick = {
//                    ovm.addObject()
//                    ovm.setLapicero()
//                    ovm.setSum(ovm.lapicero.value)
//
//                    expanded = false
//                }) {
//                    Text(text = "Lapicero $15")
//                }
//                DropdownMenuItem(onClick = {
//                    ovm.addObject()
//                    ovm.setCuaderno()
//                    ovm.setSum(ovm.cuaderno.value)
//
//                    expanded = false
//                }) {
//                    Text(text = "Cuaderno $30")
//                }
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
















