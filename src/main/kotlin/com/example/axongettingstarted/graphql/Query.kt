package com.example.axongettingstarted.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver

class Query: GraphQLQueryResolver {
   fun version() = "1.0.1"
}