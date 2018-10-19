package com.example.axongettingstarted.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver

class Mutation: GraphQLMutationResolver {
    fun version() = "1.0.3"
}