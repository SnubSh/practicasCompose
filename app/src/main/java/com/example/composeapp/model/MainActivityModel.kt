package com.example.composeapp.model

import com.example.composeapp.interfaceView.InterfaceView
//ViewModel()
class MainActivityModel : InterfaceView.Model {
//Nuevas propiedades
//private val counter = mutableStateOf(0)
//val counter: State<Int> = _counter //import runtime
//fun add(){
// _counter.value = _counter.value + 1}
//
//
//
//

    private var mCounter = 0

    override fun getCounter() = mCounter

    override fun incrementCounter() {
        
        mCounter++
    }

    override fun incrementCounterFor2(){

        mCounter = mCounter + 2
    }
    override fun incrementCounterFor5(){

        mCounter = mCounter + 5

    }
    override fun decreaseCounter(){

        mCounter = mCounter - 1
    }

    override fun resetCounter(){

        mCounter = 0
    }
//


}