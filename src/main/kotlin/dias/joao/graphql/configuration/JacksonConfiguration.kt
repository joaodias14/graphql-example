package dias.joao.graphql.configuration

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration(proxyBeanMethods = false)
class JacksonConfiguration {
    @Bean
    fun objectMapper() = jacksonObjectMapper().apply {
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        setSerializationInclusion(JsonInclude.Include.NON_NULL)
        setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
        registerModule(JavaTimeModule())
    }
}
