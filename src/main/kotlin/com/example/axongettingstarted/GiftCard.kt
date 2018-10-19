package com.example.axongettingstarted

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.commandhandling.model.AggregateIdentifier
import org.axonframework.commandhandling.model.AggregateLifecycle
import org.axonframework.eventsourcing.EventSourcingHandler

class GiftCard () {

    @AggregateIdentifier
    private lateinit var id:String
    private  var remainingValue:Int = 0


    @CommandHandler
    constructor(cmd:IssueCmd): this(){
        if (cmd.amount <= 0) throw IllegalArgumentException("amount <=0")
        AggregateLifecycle.apply(IssuedEvt(cmd.id, cmd.amount))
    }


    @EventSourcingHandler
    fun on(evt: IssuedEvt){
        id = evt.id
        remainingValue = evt.amount
    }

    @CommandHandler
    fun handle(cmd:RedeemCmd){
        if (cmd.amount <= 0) throw IllegalArgumentException("amount <= 0")
        if (cmd.amount > remainingValue) throw IllegalStateException("amount > remaining value")
        AggregateLifecycle.apply(RedeemedEvt(id, cmd.amount))
    }


    @EventSourcingHandler
    fun on(evt:RedeemedEvt){
        remainingValue -= evt.amount
    }

}