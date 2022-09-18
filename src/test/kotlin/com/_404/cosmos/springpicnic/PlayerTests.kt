package com._404.cosmos.springpicnic

import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.player.entity.Player
import com._404.cosmos.springpicnic.player.repository.PlayerRepository
import com._404.cosmos.springpicnic.player.service.PlayerService
import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import org.hibernate.exception.ConstraintViolationException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import java.time.LocalDateTime

@Suppress("NonAsciiCharacters", "TestFunctionName")
@SpringBootTest
class PlayerTests {

    @Autowired
    lateinit var playerRepository: PlayerRepository

    @Autowired
    lateinit var scenarioRepository: ScenarioRepository

    @Autowired
    lateinit var playerService: PlayerService

    val scenario1: Scenario = Scenario(id=1, gameSpan = 10, loadSize = 20)
    val player1 : Player = Player(authToken = "token", expireAt = LocalDateTime.now().plusMonths(1))

    @BeforeEach
    fun setUp(){
        playerRepository.deleteAll()
        scenarioRepository.deleteAll()
    }
    @Test
    fun 플레이어를_추가_한다(){
        playerRepository.save(player1)

        Assertions.assertEquals(1, playerRepository.count())

        val playerDB = playerRepository.findAll()[0]

        Assertions.assertEquals( player1.authToken, playerDB.authToken)
        Assertions.assertNull(playerDB.scenario)
        Assertions.assertEquals(GameStatus.NONE, playerDB.gameStatus)
    }





    @Test
    fun 인가키가_중복된_플레이어가_추가_된다(){
        playerService.createPlayerExpireAfterMonth("test_token")

        Assertions.assertThrows(DataIntegrityViolationException::class.java){
            playerService.createPlayerExpireAfterMonth("test_token")
        }

    }

    @Test
    fun 플레이어가_시나리오를_시작한다(){
        playerService.createPlayerExpireAfterMonth("test_token")
        scenarioRepository.save(scenario1)

        var player = playerRepository.findByAuthToken("test_token").get()
        // 방금 추가한 player 의 id 가 null 일리는 없으므로 !! 를 붙임
        // 시나리오1 시작
        playerService.startScenario(player.id!!, scenario1.id);

        player = playerRepository.findByAuthToken("test_token").get()

        Assertions.assertEquals(GameStatus.PROGRESS, player.gameStatus)
        Assertions.assertEquals(0, player.gameTime)
        Assertions.assertEquals(player.scenario, scenario1)

    }

    @Test
    fun 시나리오가_않았는데_시나리오를_시작한다(){
        playerService.createPlayerExpireAfterMonth("test_token")
        scenarioRepository.save(scenario1)

        val player = playerRepository.findByAuthToken("test_token").get()
        // 방금 추가한 player 의 id 가 null 일리는 없으므로 !! 를 붙임
        playerService.startScenario(player.id!!, scenario1.id);

        Assertions.assertThrows(IllegalAccessException::class.java){
            playerService.startScenario(player.id!!, scenario1.id);
        }
    }

    @Test
    fun 만료일이_한달후인_유저를_생성한다(){
        playerService.createPlayerExpireAfterMonth("test_token")
        val user = playerRepository.findByAuthToken("test_token").get()

        Assertions.assertEquals(user.createdAt.plusMonths(1), user.expireAt)
    }

    @Test
    fun 모든_데이터를_지운다(){
        playerService.createPlayerExpireAfterMonth("test_token1")
        playerService.createPlayerExpireAfterMonth("test_token2")
        Assertions.assertEquals(2, playerRepository.count())

        playerRepository.deleteAll()
        Assertions.assertEquals(0, playerRepository.count())
    }
}