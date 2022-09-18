package com._404.cosmos.springpicnic.player.service

import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.player.entity.Player
import com._404.cosmos.springpicnic.player.repository.PlayerRepository
import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class PlayerServiceImpl : PlayerService {
	@Autowired
	lateinit var playerRepository: PlayerRepository

	@Autowired
	lateinit var scenarioRepository: ScenarioRepository

	override fun startScenario(playerId: Long, scenarioId: Long) {

		val player = playerRepository.findById(playerId).get()
		val scenario = scenarioRepository.findById(scenarioId).get()

		// 원래는 NONE 상태가 아니더라도 초기화를 거쳐 게임을 새로 시작할 수 있지만
		// 아직 미구현이므로 일단 예외처리
		when(player.gameStatus){
			GameStatus.NONE -> {
				player.scenario = scenario
				player.gameStatus = GameStatus.PROGRESS
				player.gameTime = 0
			}
			else -> throw IllegalAccessException()
		}

		playerRepository.save(player)

	}

	override fun createPlayerExpireAfterMonth(authToken: String) {
		val player =  Player(authToken = authToken, expireAt = LocalDateTime.now().plusMonths(1))
		playerRepository.save(player)
	}
}