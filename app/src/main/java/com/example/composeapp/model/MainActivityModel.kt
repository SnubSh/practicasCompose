

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class MainActivityModel :ViewModel() {

private val _counter = mutableStateOf(0)
    val counter:State<Int> = _counter

fun add(){
    _counter.value = _counter.value + 1
}
    fun reset(){
        _counter.value =0
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