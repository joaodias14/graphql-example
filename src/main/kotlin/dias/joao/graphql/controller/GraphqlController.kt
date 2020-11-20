package dias.joao.graphql.controller

import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class GraphqlController() : Query {
    suspend fun test() = "Hello World"
}
