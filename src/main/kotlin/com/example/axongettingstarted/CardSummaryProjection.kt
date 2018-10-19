package com.example.axongettingstarted

import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryHandler
import java.util.concurrent.CopyOnWriteArrayList
import java.util.stream.Collectors

class CardSummaryProjection {
    private val cardSummaries = CopyOnWriteArrayList<CardSummary>()

    @EventHandler
    fun on(evt:IssuedEvt){
        val cardSummary = CardSummary(evt.id, evt.amount,  evt.amount)
        cardSummaries.add(cardSummary)
    }

    @EventHandler
    fun on(evt:RedeemedEvt){
        cardSummaries.stream()
                .filter {cs -> cs.id == evt.id}
                .findFirst()
                .ifPresent { cardSummary ->
                    val updatedCardSummary = cardSummary.deductAmount(evt.amount)
                    cardSummaries.remove(cardSummary)
                    cardSummaries.add(updatedCardSummary)
                }
    }

    @QueryHandler
    fun fetch(query: FetchCardSummariesQuery):List<CardSummary> {
        return cardSummaries
                .stream()
                .skip(query.offset)
                .limit(query.size)
                .collect(Collectors.toList())
    }
}