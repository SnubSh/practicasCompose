package com.example.composeapp.interfaceView

interface InterfaceView {

    interface View{
        fun initView()
        fun updateViewData()
        fun decreaseValue()
        fun incrementValueForTwo()
        fun incrementValueForFive()
        fun resetValue()
    }

    interface Presenter{
        fun incrementValue()
        fun getCounterValue():String
        fun decreaseValue()
        fun incrementValueForTwo()
        fun incrementValueForFive()
        fun resetValue()


    }

    interface Model{
        fun getCounter():Int
        fun incrementCounter()
        fun incrementCounterFor2()
        fun incrementCounterFor5()
        fun decreaseCounter()
        fun resetCounter()


    }

    interface Contract{

    }
}