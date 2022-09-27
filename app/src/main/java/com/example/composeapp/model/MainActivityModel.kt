package com.example.composeapp.model

import com.example.composeapp.interfaceView.InterfaceView

class MainActivityModel : InterfaceView.Model {

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



}