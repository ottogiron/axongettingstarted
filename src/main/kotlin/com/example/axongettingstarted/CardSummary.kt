package com.example.axongettingstarted

data class CardSummary(val id:String, val initialAmount:Int, val remainingAmount:Int){

        fun deductAmount(toBeDeducted:Int): CardSummary =
                CardSummary(id, initialAmount, remainingAmount - toBeDeducted)

}