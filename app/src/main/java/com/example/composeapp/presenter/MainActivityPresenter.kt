package com.example.composeapp.presenter

import com.example.composeapp.interfaceView.InterfaceView.*
import com.example.composeapp.model.MainActivityModel
import com.example.composeapp.view.MainActivity

class MainActivityPresenter(_view:View):Presenter {

    private var model: Model = MainActivityModel()
    private var view: View = _view

    init {
        view.initView()
    }

    override fun incrementValue() {

        model.incrementCounter()
        view.updateViewData()
    }

    override fun getCounterValue() = model.getCounter().toString()
    override fun decreaseValue() {

        model.decreaseCounter()
        view.updateViewData()
    }

    override fun resetValue(){
        model.resetCounter()
        view.updateViewData()

    }
    override fun incrementValueForTwo(){
        model.incrementCounterFor2()
        view.updateViewData()
    }
    override fun incrementValueForFive(){
        model.incrementCounterFor5()
        view.updateViewData()
    }




}