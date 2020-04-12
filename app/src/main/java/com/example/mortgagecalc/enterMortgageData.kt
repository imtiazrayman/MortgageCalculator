package com.example.mortgagecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_enter_mortgage_data.*
import java.math.BigDecimal
import java.math.RoundingMode

class enterMortgageData : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_mortgage_data)

    }

    fun calcData(view: View) {
        var amount = 0.0f
        var interest = 0.0f
        var years = 10.0

        if(editText.text.isNullOrBlank()){
            amount = 0.0f
        }else{
            amount = editText.text.toString().toFloat()
        }

        if(editText2.text.isNullOrBlank()){
            interest = 0.0f
        }else{
             interest = editText2.text.toString().toFloat()
        }

        if(radioButton.isChecked){
            years = 10.0
        }
        else if(radioButton3.isChecked){
            years = 15.0
        }
        else if(radioButton2.isChecked) {
            years = 30.0
        }


       // MainActivity.infoPassed.monthlyPayment(interest, amount, years)

       // MainActivity.infoPassed.monthlyPayment(interest, amount, years)
       // var j = mortgageAnalyzer().monthlyPayment(amount, interest, 15.0);


        var j = mortgageAnalyzer(interest ,amount, years )
        MainActivity.amountStatus = j.amount.toString()

        MainActivity.yearsStatus = j.years.toInt().toString()

        var formatedrate = j.rate * 100

        MainActivity.interestStatus = formatedrate.toString()

        if(j.totalPayment().isNaN()){
            MainActivity.totalStatus = "0.00"
        }else{
            MainActivity.totalStatus = j.totalPayment().toString()
        }

        if(j.monthlyPayment().isNaN()){
            MainActivity.monthlyStatus = "0.00"
        }else{
            MainActivity.monthlyStatus = j.monthlyPayment().toString()
        }




        this.finish() //this brings us back to the first activity
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }



}
