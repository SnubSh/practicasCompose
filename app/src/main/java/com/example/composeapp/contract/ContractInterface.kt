package com.example.composeapp.contract

import androidx.compose.runtime.Composable

interface ContractInterface
{
    interface View
    {
        fun initView()
        fun updateViewData()

        fun updateCounter()  // reset

        fun updateCounter_by_two()

        fun updateCounter_by_five()

    }

    interface Presenter
    {
        fun incrementValue()
        fun getCounter():String

        fun resetValue() //call Model to reset

        fun incrementValueByTwo()

        fun incrementValueByFive()
    }

    interface Model
    {
        fun getCounter():Int

        fun incrementCounter()

        fun resetCounter()

        fun incrementCounterFor2()

        fun plus()

    }
}