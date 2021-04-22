package com.sipahi.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSayiTikla(view: View) {
        if(yeniOperator)
        {
            txtSayiGoster.setText("")
        }
        yeniOperator=false

        var btnSec = view as Button
        var btnTiklaDeger: String = txtSayiGoster.text.toString()

        when (btnSec.id) {
            btn0.id -> {
                btnTiklaDeger += "0"
            }
            btn1.id -> {
                btnTiklaDeger += "1"
            }
            btn2.id -> {
                btnTiklaDeger += "2"
            }
            btn3.id -> {
                btnTiklaDeger += "3"
            }
            btn4.id -> {
                btnTiklaDeger += "4"
            }
            btn5.id -> {
                btnTiklaDeger += "5"
            }
            btn6.id -> {
                btnTiklaDeger += "6"
            }
            btn7.id -> {
                btnTiklaDeger += "7"
            }
            btn8.id -> {
                btnTiklaDeger += "8"
            }
            btn9.id -> {
                btnTiklaDeger += "9"
            }
            btnTC.id -> {
                btnTiklaDeger = "-" + btnTiklaDeger
            }
        }

        txtSayiGoster.setText(btnTiklaDeger)
    }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOpTikla(view: View) {
        var btnSec = view as Button
        when (btnSec.id) {
            btnB.id -> {
                operator = "/"
            }
            btnX.id -> {
                operator = "x"
            }
            btnA.id -> {
                operator = "+"
            }
            btnE.id -> {
                operator = "-"
            }
        }
        eskiSayi = txtSayiGoster.text.toString()
        yeniOperator = true
    }

    fun btnEsit(view: View) {
        var yeniSayi = txtSayiGoster.text.toString()
        var sonucSayisi: Double? = null

        when (operator) {
            "/" -> {
                sonucSayisi = eskiSayi.toDouble() / yeniSayi.toDouble()
            }
            "x" -> {
                sonucSayisi = eskiSayi.toDouble() * yeniSayi.toDouble()
            }
            "-" -> {
                sonucSayisi = eskiSayi.toDouble() - yeniSayi.toDouble()
            }
            "+" -> {
                sonucSayisi = eskiSayi.toDouble() + yeniSayi.toDouble()
            }
        }

        txtSayiGoster.setText(sonucSayisi.toString())
        yeniOperator = true
    }

    fun btnSil(view: View) {
        txtSayiGoster.setText("0")
        yeniOperator=true
    }

    fun btnYuzde(view: View) {
        var sayi: Double = txtSayiGoster.text.toString().toDouble() / 100
        txtSayiGoster.setText(sayi.toString())
        yeniOperator = true
    }
}