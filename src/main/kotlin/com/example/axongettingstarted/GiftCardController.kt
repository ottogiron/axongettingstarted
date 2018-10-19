package com.example.axongettingstarted

import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes

class GiftCardController {

    lateinit var commandGateway: CommandGateway
    lateinit var queryGateway: QueryGateway

//    fun issue(@RequestParam(value = "id") id:String, @RequestParam(value = "amount") amount:Int){
//        commandGateway.sendAndWait<IssueCmd>(IssueCmd(id, amount))
//    }
//
//    fun sumaries(@RequestParam(value="size", defaultValue = "10") size:Long, @RequestParam(value = "offset", defaultValue = "0") offset:Long): List<CardSummary>{
//        return queryGateway.query(FetchCardSummariesQuery(size,offset), ResponseTypes.multipleInstancesOf(CardSummary::class.java))
//                .get()
//    }
}