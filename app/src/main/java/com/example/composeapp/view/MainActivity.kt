package com.example.composeapp.view
import MainActivityModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

//val gray = Color(	0xFFE6E6E6)
//val azul = Color(	0xFF8904B1)





class MainActivity : ComponentActivity() {
    val ovm:MainActivityModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)

     setContent {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                string()
                ViewPractice()
                ButtonResetValue()
                ButtonDecreaseValue()
                ButtonIncrementValueFor2()
                ButtonIncrementFor5Value()

            }
        }
    }


    @Composable
    fun ViewPractice() {

        Button(onClick = {ovm.add()}) {
            Text(text = "Sumar + 1")
            
        }

    }
    @Composable
    fun string() {
        Text(text = "Valor es: "+ovm.counter.value.toString())



    }
    @Composable
    fun ButtonResetValue(){
        Button(onClick = { ovm.reset() } ) {
            Text(text = "Reiniciar")

        }
    }
    @Composable
    fun ButtonDecreaseValue(){
        Button(onClick = {  ovm.restar()} ) {
            Text(text = "Restar")

        }
    }
    @Composable
    fun ButtonIncrementValueFor2(){
        Button(onClick = {  ovm.sumarFor2()} ) {
            Text(text = "incrementar + 2")

        }
    }
    @Composable
    fun ButtonIncrementFor5Value(){
        Button(onClick = { ovm.sumarFor5() } ) {
            Text(text = "incrementar + 5")

        }
    }


    //Vista previa
    @Preview(showSystemUi= true)
    @Composable
    fun Preview() {
        ViewPractice()
    }





}









