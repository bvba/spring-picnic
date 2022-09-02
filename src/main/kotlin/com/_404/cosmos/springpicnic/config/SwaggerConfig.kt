package com._404.cosmos.springpicnic.config

import com._404.cosmos.springpicnic.common.ProfileHolder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.web.reactive.config.EnableWebFlux
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@EnableWebFlux
class SwaggerConfig {

	@Bean
	@Profile(ProfileHolder.PROFILE_DEFAULT, ProfileHolder.PROFILE_DEV)
	fun swaggerApi(): Docket {
		return Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.any())
			.paths(PathSelectors.ant("/error").negate())
			.build()
	}
}
