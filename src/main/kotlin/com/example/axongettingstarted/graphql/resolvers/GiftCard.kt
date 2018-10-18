package com.example.axongettingstarted.graphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.coxautodev.graphql.tools.GraphQLResolver
import com.example.axongettingstarted.CardSummary
import com.example.axongettingstarted.FetchCardSummariesQuery
import com.example.axongettingstarted.IssueCmd
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class SummariesQueryResolver: GraphQLQueryResolver {

    @Autowired
    lateinit var queryGateway: QueryGateway

    fun cardSummaries(size:Long, offset:Long): List<CardSummary> =
            queryGateway.query(FetchCardSummariesQuery(10,0), ResponseTypes.multipleInstancesOf(CardSummary::class.java))
                    .get()
}


@Component
class IssueCardMutationResolver: GraphQLMutationResolver {

    @Autowired
    lateinit var commandGateway: CommandGateway

    fun issueCard(amount:Int){
        val id = UUID.randomUUID()
        commandGateway.sendAndWait<IssueCmd>(IssueCmd(id.toString(), amount))
    }
}