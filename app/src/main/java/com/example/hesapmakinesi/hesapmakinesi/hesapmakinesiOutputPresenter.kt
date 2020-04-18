package com.example.hesapmakinesi.hesapmakinesi

import bsh.Interpreter
import java.lang.Exception


object hesapmakinesiOutputPresenter{

    private var mView: hesapmakinesiOutputInterfaceView? = null

    private var mCurrentEqation: String=""

    private var mCurrentOutcome: String=""

    private val mInterpreter = Interpreter()

    fun attach(view: hesapmakinesiOutputInterfaceView){
        mView = view
        updateEquation()
        updateOutcome()
    }

    fun detach(){
        mView = null
    }

    fun add(item: String){
        mCurrentEqation = mCurrentEqation.plus(item)
        updateEquation()
        hesapmakinesiOutcome()
        updateOutcome()
    }
    fun remove(){
        mCurrentEqation = if (mCurrentEqation.length > 1){
             mCurrentEqation.substring(0, mCurrentEqation.length - 1)
        }else{
            ""
        }
        updateEquation()
        hesapmakinesiOutcome()
        updateOutcome()
    }
    fun solve(){
        if (mCurrentOutcome.isNotEmpty()){
            mCurrentEqation = mCurrentOutcome
            mCurrentOutcome = ""
        }
        updateEquation()
        updateOutcome()
    }
    fun clear(){
        mCurrentEqation = ""
        mCurrentOutcome = ""
        updateEquation()
        updateOutcome()
    }

    private fun hesapmakinesiOutcome(){
        if (mCurrentEqation.isNotEmpty()){
            try {
                mInterpreter.eval("result = $mCurrentEqation")
                val result = mInterpreter.get("result")
                if (result != null && result is Int){
                    mCurrentOutcome = result.toString()
                }
            } catch (e: Exception){
                mCurrentOutcome = ""
            }
        }else{
            mCurrentOutcome = ""
        }
    }

    private fun updateEquation(){
        mView?.setEquation(mCurrentEqation)
    }
    private fun updateOutcome(){
        mView?.setOutcome(mCurrentOutcome)
    }
}