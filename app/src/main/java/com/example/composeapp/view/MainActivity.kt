package com.example.composeapp.view
import MainActivityModel
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.R


//val gray = Color(	0xFFE6E6E6)
//val azul = Color(	0xFF8904B1)





class MainActivity : ComponentActivity() {
    val ovm: MainActivityModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            viewComponents()

        }
    }
@Composable
fun viewComponents(){
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(all = 30.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
        ) {
        titles("Cotizador de autos nuevos")
        Row(
            Modifier.clip(shape = RoundedCornerShape(20.dp))
        ) {
            Image(painterResource(id = R.drawable.coin),"",Modifier.size(90.dp))

        }

        input(ovm)
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            titles("Vehículo:")
            marcas(ovm = ovm)
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            titles("Enganche:")
            enganche(ovm = ovm)
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            titles("Financiamiento (anual):")
            financiamiento(ovm = ovm)
        }
        containerTexts(ovm = ovm)


    }

}



    @Composable

    fun containerTexts(ovm: MainActivityModel) {


        Card(
            Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Nombre : ")
                    Text(text = " ${ ovm.nombre.value.toString()}", fontWeight = FontWeight.Bold)
                }
                Divider()
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Text(text = "Vehículo : ")
                    Text(text = "${ovm.marca.value.toString()}", fontWeight = FontWeight.Bold)

                }
                Divider()
                Text(text = "Enganche : ")
                Text(text = "(${ovm.porcentaje.value.toString()}%) de $ ${ovm.enganche.value.toString()}", fontWeight = FontWeight.Bold)
                Divider()
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Monto a financiar: ")
                    Text(
                        text = "$ ${ovm.financiamiento.value.toString()}",
                        fontWeight = FontWeight.Bold
                    )

                }
                Divider()
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Financiamiento : a ")
                    Text(text = "${ovm.plazo.value}", fontWeight = FontWeight.Bold)
                }
                Divider()
                Text(text = "Monto de intereses por ${ovm.anios.value.toString()} años: ")
                Text(text = "$ ${ovm.interes.value.toString()}", fontWeight = FontWeight.Bold)
                Divider()
                Text(text = "Monto a financiar + intereses: ")
                Text(text = "$ ${ovm.financiamiento.value.toString()} + $ ${ovm.interes.value.toString()} = ${ovm.total.value.toString()}", fontWeight = FontWeight.Bold)
                Divider()
                Text(text = "Pagos mensuales por: ")
                Text(text = "$ ${ovm.pagomensual.value.toString()}", fontWeight = FontWeight.Bold)
                Divider()
                Text(text = "Costo total ( Enganche + Financiamiento ): ")
                Text(text = "$ ${ovm.enganche.value.toString()} + $ ${ovm.total.value.toString()} = $ ${ovm.enganche.value + ovm.total.value}", fontWeight = FontWeight.Bold)
                Divider()
                Button(onClick = {ovm.clearData()},Modifier.fillMaxWidth()) {
                    Text(text = "Limpiar")
                }
            }
        }
    }

    @Composable
    fun input(ovm: MainActivityModel) {
        var _nombre = remember {
            mutableStateOf("")
        }
        Column(
            Modifier.fillMaxWidth(),
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                titles(title = "Nombre:")
                TextField(
                    value = _nombre.value, onValueChange = {
                        _nombre.value = it
                        ovm.setName(_nombre.value)
                    },
                    Modifier.width(250.dp),
                    keyboardOptions = KeyboardOptions(KeyboardCapitalization.None, true, KeyboardType.Text),
                )
            }

        }
        
    }

    @Composable
    fun titles(title:String) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 15.sp)
    }

    @Composable
    fun marcas(ovm: MainActivityModel) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "Honda Accord $678,026.22",
            "Vw Touareg $879,266.15",
            "BMW X5 $1,025,366.87",
            "Mazda CX7 $988,641.02",
        )
        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Marca")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        ovm.setMarca(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
    @Composable
    fun enganche(ovm: MainActivityModel) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "20%",
            "40%",
            "60%",
        )
        Box(

        ) {
            Button(onClick = { expanded = !expanded }) {
                Text("Porcentaje")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(

                expanded = expanded,
                onDismissRequest = { expanded = true },

            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        ovm.setPorcentaje(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
    @Composable
    fun financiamiento(ovm: MainActivityModel) {
        var expanded by remember { mutableStateOf(false) }
        val labels = listOf(
            "1 año al 7.5%",
            "2 años al 9.5%",
            "3 años al 10.3%",
            "4 años al 12.6%",
            "5 años al 13.5%",
        )
        Box {
            Button(onClick = { expanded = !expanded }) {
                Text("Plazo")
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = true },
            ) {
                labels.forEach { label ->
                    DropdownMenuItem(onClick = {
                        ovm.setFinanciamiento(labels.indexOf(label))
                        expanded = false
                    }) {
                        Text(text = label)
                    }
                }
            }
        }
    }
}