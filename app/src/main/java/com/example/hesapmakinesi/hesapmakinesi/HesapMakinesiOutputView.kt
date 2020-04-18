package com.example.hesapmakinesi.hesapmakinesi

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.hesapmakinesi.R
import kotlinx.android.synthetic.main.view_hesapmakinesi_cikisi.view.*

class HesapMakinesiOutputView(context:Context,attributeSet:AttributeSet?): LinearLayout(context,attributeSet), hesapmakinesiOutputInterfaceView{

    init {

        orientation = VERTICAL

        gravity = Gravity.CENTER_VERTICAL

        LayoutInflater.from(context).inflate(R.layout.view_hesapmakinesi_cikisi,this,true )

    }

    fun addItem(item: String){
        hesapmakinesiOutputPresenter.add(item)
    }
    fun removeItem(){
        hesapmakinesiOutputPresenter.remove()
    }
    fun solve(){
        hesapmakinesiOutputPresenter.solve()
    }
    fun clear(){
        hesapmakinesiOutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        hesapmakinesiOutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        hesapmakinesiOutputPresenter.detach()
    }

    override fun setEquation(equatian: String) {
        hesapmakinesi_giris_equation.text = equatian
    }

    override fun setOutcome(outcome: String) {
        hesapmakinesi_giris_outcome.text = outcome
    }
}