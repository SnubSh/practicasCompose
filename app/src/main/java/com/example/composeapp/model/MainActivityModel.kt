

import android.widget.Switch
import androidx.compose.material.Switch
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainActivityModel :ViewModel() {

    private val _counter = mutableStateOf(0)
    val counter:State<Int> = _counter
    private val _nObjects = mutableStateOf(0)
    val nObjects:State<Int> = _nObjects
    private val _descuento = mutableStateOf(0)
    val descuento:State<Int> = _descuento

    private val _text = mutableStateOf("")
    val text:State<String> = _text

    private val _textDropDown = mutableStateOf("")
    val textDropDown:State<String> = _textDropDown

    private val _lapiz = mutableStateOf(0)
    val lapiz:State<Int> = _lapiz

    private val _lapicero = mutableStateOf(0)
    val lapicero:State<Int> = _lapicero

    private val _borrador = mutableStateOf(0)
    val borrador:State<Int> = _borrador

    private val _cuaderno = mutableStateOf(0)
    val cuaderno:State<Int> = _cuaderno

    private val _result = mutableStateOf(0)
    val result:State<Int> = _result

    private val _sexo = mutableStateOf("")
    val sexo:State<String> = _sexo
    private val _tiene = mutableStateOf("")
    val tiene:State<String> = _tiene

    private val _estatura = mutableStateOf(0.0)
    val estatura:State<Double> = _estatura

    private val _peso = mutableStateOf(0.0)
    val peso:State<Double> = _peso

    private val _imc = mutableStateOf(0.0)
    val imc:State<Double> = _imc



    fun calculateIMC(peso:String,altura:String){
        _estatura.value = altura.toDouble()
        _peso.value = peso.toDouble()

        _imc.value =  _peso.value / (_estatura.value * _estatura.value)

        _imc.value.toString().replace(",",".")

        setTiene(_imc.value.toDouble())

    }
    fun setTiene(value:Double){


        if(value < 18.4){
            _tiene.value = "Insuficiencia ponderal/ Bajo peso"
        }
        else
            if(value ==  18.5 || value <= 24.9) {
            _tiene.value = "Normopeso"
            }
        else
            if(value ==  25.0 || value <= 29.9){
            _tiene.value = "Sobrepeso"
            }
        else
            if(value == 30.0 || value <= 34.9){
            _tiene.value = "Obesidad grado I"
            }
        else
            if(value == 35.0 || value <= 39.9){
            _tiene.value = "Obesidad grado II"
            }
        else
            if(value > 40){
            _tiene.value = "Obesidad grado III o mórbida"
        }



    }
    fun setStringDropDown(msg:String){
        _textDropDown.value = msg
    }
    fun setFemenino(){
    _sexo.value="Femenino"
    }
    fun setMasculino(){
        _sexo.value="Masculino"
    }
    fun setLapiz(){
        _lapiz.value = 10
    }
    fun setLapicero(){
        _lapicero.value = 15
    }
    fun setBorrador(){
        _borrador.value = 5
    }
    fun setCuaderno(){
        _cuaderno.value = 30
    }
    fun setSum(value:Int){
        _result.value = _result.value + value
    }
    fun addObject(){
    _nObjects.value = _nObjects.value + 1
}
    fun reset(){
        _result.value = 0
    }
    fun restar(value: Double){
        _descuento.value = value.toInt()
        _result.value  = _result.value - value.toInt()

    }
    fun sumar(){
        _counter.value=_counter.value+2
    }

    fun sumarFor2(){
        _counter.value = _counter.value+2
    }
    fun sumarFor5(){
        _counter.value = _counter.value+5
    }

//
//
//


}