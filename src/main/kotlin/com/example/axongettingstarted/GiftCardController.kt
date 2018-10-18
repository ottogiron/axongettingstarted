package com.example.axongettingstarted

import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GiftCardController {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @Autowired
    lateinit var queryGateway: QueryGateway

    @GetMapping("/issue")
    fun issue(@RequestParam(value = "id") id:String, @RequestParam(value = "amount") amount:Int){
        commandGateway.sendAndWait<IssueCmd>(IssueCmd(id, amount))
    }

    @GetMapping("/summaries")
    fun sumaries(@RequestParam(value="size", defaultValue = "10") size:Long, @RequestParam(value = "offset", defaultValue = "0") offset:Long): List<CardSummary>{
        return queryGateway.query(FetchCardSummariesQuery(size,offset), ResponseTypes.multipleInstancesOf(CardSummary::class.java))
                .get()
    }
}