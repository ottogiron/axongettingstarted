package com.example.axongettingstarted

import org.axonframework.commandhandling.TargetAggregateIdentifier

data class IssueCmd(val id:String, val amount:Int)
data class RedeemCmd(@TargetAggregateIdentifier val id:String, val amount: Int)