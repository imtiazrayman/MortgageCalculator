package com.example.mortgagecalc

class mortgageAnalyzer(ratePassed : Float, amountPassed : Float, yearsPassed : Double) {
    /*var rate: Float = 0.0f
    var years: Double = 0.0
    var amount: Float = 0.0f*/

    var rate: Float = ratePassed
    var years: Double = yearsPassed
    var amount: Float = amountPassed

    init{

    }

    fun monthlyPayment(): Float {

        val mRate: Float = rate / 12 // monthly interest rate
        val temp = Math.pow(1 / (1 + mRate).toDouble(), years * 12)

        return amount * mRate / (1 - temp).toFloat()
    }

    fun totalPayment(): Float {
        var monthly = monthlyPayment()
        var yearly = monthly * 12
        var totalpayment = yearly * years

        return totalpayment.toFloat()

    }





    



}