package com.example.axongettingstarted.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

class Query: GraphQLQueryResolver {
   fun version() = "1.0.1"
}