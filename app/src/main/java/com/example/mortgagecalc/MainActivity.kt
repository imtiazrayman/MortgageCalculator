package com.example.mortgagecalc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object mortgageInfo{
        var amountStatus = "0.0"
        var interestStatus = "0.0"
        var yearsStatus = "0"
        var monthlyStatus = "0.0"
        var totalStatus = "0.0"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

    }
    override fun onResume() {
        super.onResume()
        Amount.text = "$$amountStatus"
        InterestRate.text = "$interestStatus%"
        Years.text = yearsStatus
        MonthlyPayment.text = "$$monthlyStatus"
        TotalPayment.text = "$$totalStatus"
    }



    fun editData(view: View) {
        var myintent = Intent(this, enterMortgageData::class.java ) // this will send us to activity 2
        //myintent.putExtra("msgpassed","Hello From Act 1") // this is one way to work the program

        startActivity(myintent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
