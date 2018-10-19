package com.example.axongettingstarted.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.example.axongettingstarted.CardSummary
import com.example.axongettingstarted.FetchCardSummariesQuery
import com.example.axongettingstarted.IssueCmd
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import java.util.*

class SummariesQueryResolver: GraphQLQueryResolver {

    lateinit var queryGateway: QueryGateway

    fun cardSummaries(size:Long, offset:Long): List<CardSummary> =
            queryGateway.query(FetchCardSummariesQuery(10,0), ResponseTypes.multipleInstancesOf(CardSummary::class.java))
                    .get()
}


class IssueCardMutationResolver: GraphQLMutationResolver {

    lateinit var commandGateway: CommandGateway

    fun issueCard(amount:Int):String{
        val id = UUID.randomUUID()
        commandGateway.sendAndWait<IssueCmd>(IssueCmd(id.toString(), amount))
        return id.toString()
    }
}