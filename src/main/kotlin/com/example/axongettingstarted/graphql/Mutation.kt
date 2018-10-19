package com.example.axongettingstarted.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

class Mutation: GraphQLMutationResolver {
    fun version() = "1.0.3"
}