package dias.joao.graphql.configuration

import com.expediagroup.graphql.execution.KotlinDataFetcherFactoryProvider
import com.expediagroup.graphql.execution.SimpleKotlinDataFetcherFactoryProvider
import com.expediagroup.graphql.spring.execution.SpringDataFetcher
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import graphql.schema.DataFetcherFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.reflect.KFunction


@Configuration(proxyBeanMethods = false)
class GraphQLConfiguration {
    @Bean
    fun dataFetcherFactoryProvider(applicationContext: ApplicationContext): KotlinDataFetcherFactoryProvider =
            SpringKotlinDataFetcherFactoryProvider(jacksonObjectMapper(), applicationContext)
}

class SpringKotlinDataFetcherFactoryProvider(private val objectMapper: ObjectMapper,
                                             private val applicationContext: ApplicationContext) : SimpleKotlinDataFetcherFactoryProvider(objectMapper) {
    override fun functionDataFetcherFactory(target: Any?, kFunction: KFunction<*>): DataFetcherFactory<Any?> =
            DataFetcherFactory { SpringDataFetcher(target, kFunction, objectMapper, applicationContext) }
}
