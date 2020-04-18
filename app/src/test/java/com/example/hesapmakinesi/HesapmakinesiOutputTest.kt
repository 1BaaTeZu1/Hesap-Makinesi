package com.example.hesapmakinesi

import com.example.hesapmakinesi.hesapmakinesi.hesapmakinesiOutputInterfaceView
import com.example.hesapmakinesi.hesapmakinesi.hesapmakinesiOutputPresenter
import org.junit.*
import org.mockito.BDDMockito.*
import org.mockito.*

class HesapmakinesiOutputTest{

    private val mPresenter :hesapmakinesiOutputPresenter = hesapmakinesiOutputPresenter
    private val mMockView :hesapmakinesiOutputInterfaceView = Mockito.mock(hesapmakinesiOutputInterfaceView::class.java)

    @Test
     fun  m1plus1to2() {

        mPresenter.attach(mMockView)

        mPresenter.add("1")

        then(mMockView).should().setEquation("1")

        mPresenter.add("+")

        then(mMockView).should().setEquation("1+")

        mPresenter.add("1")

        then(mMockView).should().setEquation("1+1")

        then(mMockView).should().setOutcome("2")

        mPresenter.clear()
    }


    @Test
    fun  m2plus2minus1to3() {

        mPresenter.attach(mMockView)

        mPresenter.add("2")

        then(mMockView).should().setEquation("2")

        mPresenter.add("+")

        then(mMockView).should().setEquation("2+")

        mPresenter.add("2")

        then(mMockView).should().setEquation("2+2")

        then(mMockView).should().setOutcome("4")

        mPresenter.add("-")

        then(mMockView).should().setEquation("2+2-")

        mPresenter.add("1")

        then(mMockView).should().setEquation("2+2-1")

        then(mMockView).should().setOutcome("3")

        mPresenter.clear()
    }

}