package dias.joao.graphql.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableReactiveMethodSecurity
@Configuration(proxyBeanMethods = false)
class WebSecurityConfiguration {

    @Order(1)
    @Configuration(proxyBeanMethods = false)
    class HttpBasicSecurityConfiguration {

        @Bean
        fun httpBasicSecurityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
            return http
                    .authorizeExchange()
                    .anyExchange().permitAll()
                    .and().csrf().disable()
                    .formLogin().disable()
                    .httpBasic()
                    .and().build()
        }
    }

}
