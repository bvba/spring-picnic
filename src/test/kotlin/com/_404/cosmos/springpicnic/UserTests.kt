package com._404.cosmos.springpicnic

import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import com._404.cosmos.springpicnic.user.entity.User
import com._404.cosmos.springpicnic.user.repository.UserRepository
import com._404.cosmos.springpicnic.user.service.UserService
import org.hibernate.exception.ConstraintViolationException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.DataIntegrityViolationException
import java.time.LocalDateTime

@Suppress("NonAsciiCharacters", "TestFunctionName")
@SpringBootTest
class UserTests {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var scenarioRepository: ScenarioRepository

    @Autowired
    lateinit var userService: UserService

    val user1 : User = User(authToken = "token", expireAt = LocalDateTime.now().plusMonths(1))
    val user2 : User = User(authToken = "token2", expireAt = LocalDateTime.now().plusMonths(1))

    val scenario1: Scenario = Scenario(id=1, gameSpan = 10, loadSize = 20)
    val scenario2: Scenario = Scenario(id=2, gameSpan = 15, loadSize = 30)


    @BeforeEach
    fun setUp() {
        userRepository.deleteAll()
        scenarioRepository.deleteAll()

        scenarioRepository.save(scenario1)

    }

    @Test
    fun 인가키가_중복된_유자가_추가_된다(){
        userRepository.save(user1)
        Assertions.assertThrows(DataIntegrityViolationException::class.java){
            userService.createUserExpireAfterMonth(user1.authToken!!)
        }

    }

    @Test
    fun 유저를_추가_한다(){
        userRepository.save(user1!!)
        Assertions.assertEquals(1, userRepository.count())

    }

    @Test
    fun 유저가_시나리오를_시작한다(){
        userService.createUserExpireAfterMonth("test_token")
        
        var user = userRepository.findByAuthToken("test_token").get()
        userService.startScenario(user.id!!, scenario1.id!!);

        user = userRepository.findByAuthToken("test_token").get()
        
        Assertions.assertEquals(GameStatus.PROGRESS, user.gameStatus)
        Assertions.assertEquals(0, user.gameTime)
        Assertions.assertEquals(user.scenario!!.id, scenario1.id)

    }

    @Test
    fun 유저가_시나리오를_끝낸다(){
        // 시나리오를 끝내면 관련 행인이나 신호등 데이터를 삭제하고 
        // game status 상태를 갱신해야하는데
        // 아직 행인이나 신호등이 미구현이므로 추후 검증
    }

    @Test
    fun 존재하지_않는_시나리오를_시작한다(){
        // 추후 aop 나 필터로 구현
        // 추후 검증
    }

    @Test
    fun 게임이_끝나지_않았는데_시나리오를_끝낸다(){
        userService.createUserExpireAfterMonth("test_token")

        val user = userRepository.findByAuthToken("test_token").get()
        userService.startScenario(user.id!!, scenario1.id!!)

        Assertions.assertThrows(IllegalAccessException::class.java){
            userService.terminateScenario(user.id!!)
        }
    }

    @Test
    fun 게임이_끝나지_않았는데_시나리오를_시작한다(){
        // 게임이 끝나지 않고 시나리오를 시작하면
        // 기존 데이터 삭제하는게 검증되어야 하는데
        // 아직 신호등이나 행인이 미구현이므로 추후 검증
    }

    @Test
    fun 인가키의_유효성을_검증한다(){
        // 추후 검증
    }

    @Test
    fun 만료일이_한달후인_유저를_생성한다(){
        userService.createUserExpireAfterMonth("test_token")
        val user = userRepository.findByAuthToken("test_token").get()
        Assertions.assertEquals(user.createdAt.plusMonths(1), user.expireAt)
    }


    @Test
    fun 모든_데이터를_지운다(){
        userRepository.deleteAll()
        Assertions.assertEquals(0, userRepository.count())
    }
}