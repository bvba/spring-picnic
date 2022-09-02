package com._404.cosmos.springpicnic.common

import lombok.RequiredArgsConstructor
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class ProfileHolder(
	val env: Environment
) {
	companion object {
		const val PROFILE_DEFAULT: String = "default"
		const val PROFILE_DEV: String = "dev"
		const val PROFILE_PROD: String = "prod"
	}

	@Suppress("unused")
	fun isLocal(): Boolean = env.activeProfiles.any { profile -> listOf(PROFILE_DEV, PROFILE_PROD).contains(profile) }

	@Suppress("unused")
	fun isDev(): Boolean = env.activeProfiles.contains(PROFILE_DEV)

	@Suppress("unused")
	fun isProd(): Boolean = env.activeProfiles.contains(PROFILE_PROD)
}
