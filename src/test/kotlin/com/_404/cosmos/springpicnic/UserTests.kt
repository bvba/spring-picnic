package com._404.cosmos.springpicnic

import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import com._404.cosmos.springpicnic.user.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@Suppress("NonAsciiCharacters", "TestFunctionName")
@DataJpaTest
class UserTests {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var scenarioRepository: ScenarioRepository
    

    @Test
    fun 시나리오가_없는_유저를_추가_한다(){

    }

    @Test
    fun 시나리오가_있는_유저를_추가_한다(){

    }

    @Test
    fun 모든_데이터를_지운다(){
        userRepository.deleteAll()
        Assertions.assertEquals(0, userRepository.count())
    }
}