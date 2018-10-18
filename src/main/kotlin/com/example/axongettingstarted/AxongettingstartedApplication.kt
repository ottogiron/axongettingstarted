package com.example.axongettingstarted

import org.axonframework.config.DefaultConfigurer
import org.axonframework.config.EventHandlingConfiguration
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.axonframework.queryhandling.responsetypes.ResponseTypes
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AxongettingstartedApplication

fun main(args: Array<String>) {
    runApplication<AxongettingstartedApplication>(*args)
//    val cardSummaryProjection = CardSummaryProjection()
//    val eventHandlingConfiguration = EventHandlingConfiguration()
//    eventHandlingConfiguration.registerEventHandler { cardSummaryProjection}
//    val configuration = DefaultConfigurer.defaultConfiguration()
//            .configureAggregate(GiftCard::class.java)
//            .configureEventStore { EmbeddedEventStore(InMemoryEventStorageEngine())}
//            .registerModule(eventHandlingConfiguration)
//            .registerQueryHandler{cardSummaryProjection}
//            .buildConfiguration()
//    configuration.start()
//
//    val commandGateway = configuration.commandGateway()
//    val queryGateway = configuration.queryGateway()
//
//    commandGateway.sendAndWait<IssueCmd>(IssueCmd("gc1", 100))
//    commandGateway.sendAndWait<IssueCmd>(IssueCmd("gc2", 50))
//    commandGateway.sendAndWait<RedeemCmd>(RedeemCmd("gc1", 10))
//    commandGateway.sendAndWait<RedeemCmd>(RedeemCmd("gc2", 20))
//
//    queryGateway.query(FetchCardSummariesQuery(2,0), ResponseTypes.multipleInstancesOf(CardSummary::class.java))
//            .get()
//            .forEach {println(it)}

}
