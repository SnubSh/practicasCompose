

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainActivityModel :ViewModel() {

    private val _counter = mutableStateOf(0)
    val counter:State<Int> = _counter

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


    fun setString(msg:String){
        _text.value = msg
    }
    fun setStringDropDown(msg:String){
        _textDropDown.value = msg
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
    fun add(){
    _counter.value = _counter.value + 1
}
    fun reset(){
        _result.value = 0
    }
    fun sumar(){
        _counter.value=_counter.value+2
    }
    fun restar(){
      _counter.value  = _counter.value-1

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