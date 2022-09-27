package com.example.composeapp.view
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
import androidx.compose.ui.text.font.SystemFontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.interfaceView.InterfaceView
import com.example.composeapp.presenter.MainActivityPresenter
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.theme.componente
import org.intellij.lang.annotations.JdkConstants

//val gray = Color(	0xFFE6E6E6)
//val azul = Color(	0xFF8904B1)



private var presenter:MainActivityPresenter? = null

class MainActivity : ComponentActivity(), InterfaceView.View {


    override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
        presenter = MainActivityPresenter(_view = this)
     setContent {
            Column(
                Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                text()
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

        Button(onClick = {initView()}) {
            Text(text = "incrementar + 1")
            
        }

    }
    @Composable
    fun text() {


            Text(text = "El valor es: " + presenter?.getCounterValue())



    }
    @Composable
    fun ButtonResetValue(){
        Button(onClick = {  resetValue()} ) {
            Text(text = "Reiniciar")

        }
    }
    @Composable
    fun ButtonDecreaseValue(){
        Button(onClick = {  decreaseValue()} ) {
            Text(text = "Restar")

        }
    }
    @Composable
    fun ButtonIncrementValueFor2(){
        Button(onClick = {  incrementValueForTwo()} ) {
            Text(text = "incrementar + 2")

        }
    }
    @Composable
    fun ButtonIncrementFor5Value(){
        Button(onClick = {  incrementValueForFive()} ) {
            Text(text = "incrementar + 5")

        }
    }


    //Vista previa
    @Preview(showSystemUi= true)
    @Composable
    fun Preview() {
        ViewPractice()
    }


    override fun initView() {
    presenter?.incrementValue()
    }

    override fun updateViewData() {
    System.out.println("Valor Contador " + presenter?.getCounterValue())

    }

    override fun decreaseValue() {
        presenter?.decreaseValue()
    }

    override fun incrementValueForTwo() {
        presenter?.incrementValueForTwo()
    }

    override fun incrementValueForFive() {
        presenter?.incrementValueForFive()
    }

    override fun resetValue() {
        presenter?.resetValue()
    }

}









