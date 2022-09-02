package com._404.cosmos.springpicnic.player.service

interface PlayerService {

	fun startScenario(playerId: Long, scenarioId: Long)
	fun createPlayerExpireAfterMonth(authToken:String )
}