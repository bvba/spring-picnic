package com._404.cosmos.springpicnic.user.service

import com._404.cosmos.springpicnic.game.GameStatus
import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import com._404.cosmos.springpicnic.user.entity.User
import com._404.cosmos.springpicnic.user.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

// 해당 id 의 유저가 존재한다고 가정합니다.
// id 의 유효성 검증은 다른 필터나 aop 에서 검증되었다고 가정하고
// 핵심적인 로직만을 담당합니다.
@Service
class UserServiceImpl : UserService {
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var scenarioRepository: ScenarioRepository


    override fun startScenario(userId: Long, scenarioId: Long) {

        val user = userRepository.findById(userId).get()
        val scenario = scenarioRepository.findById(scenarioId).get()

        when(user.gameStatus){
            GameStatus.NONE -> {
                user.scenario = scenario
                user.gameStatus = GameStatus.PROGRESS
                user.gameTime = 0
            }
            else -> throw IllegalAccessException()
        }

        userRepository.save(user)
    }

    override fun terminateScenario(userId: Long) {
        val user = userRepository.findById(userId).get()
        if(user.scenario == null || user.gameStatus != GameStatus.TERMINATED) throw IllegalAccessException()

        user.scenario = null
        user.gameStatus = GameStatus.NONE

        userRepository.save(user)
    }

    override fun createUserExpireAfterMonth(authToken: String )  {
        val user =  User(authToken = authToken, expireAt = LocalDateTime.now().plusMonths(1))
        userRepository.save(user)
    }


}