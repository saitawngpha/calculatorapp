package com.saitawngpha.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var op = ""
    var isNewOp = true
    var oldNumber = ""
    var finalNumber: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buEventClick(view: View){
        if(isNewOp){
            editTxt.setText("")
        }
        isNewOp = false
        //Button click Action
        var buSelect = view as Button
        var buClickValue = editTxt.text.toString()

        when(buSelect.id) {
            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                buClickValue += "."
            }
        }

        //set to edit text
        editTxt.setText(buClickValue)

    }

    fun buEventOp(view: View){
        //operation action
        var buSelect = view as Button

        when(buSelect.id) {
            buDiv.id -> {
                op = "/"
            }
            buMulti.id -> {
                op = "*"
            }
            buSub.id -> {
                op = "-"
            }
            buSum.id -> {
                op = "+"
            }
        }

        oldNumber = editTxt.text.toString()
        isNewOp = true
    }

    fun buEqualEvent(view: View){
        //equal action
        var newNumber = editTxt.text.toString()
        when(op){
            "/" -> {
              finalNumber = oldNumber.toString().toDouble() / newNumber.toString().toDouble()
            }
            "*" -> {
                finalNumber = oldNumber.toString().toDouble() * newNumber.toString().toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toString().toDouble() - newNumber.toString().toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toString().toDouble() + newNumber.toString().toDouble()
            }
        }

        //set finalNumber to edit text
        editTxt.setText(finalNumber.toString())
        isNewOp = true

    }

    fun buClearEvent(view: View){
        //clear action
        editTxt.setText("0")
        isNewOp = true
    }

    fun buPercentEvent(view: View){
        //percent action
        val number = editTxt.text.toString().toDouble() / 100
        editTxt.setText(number.toString())
    }

}