package com._404.cosmos.springpicnic

import com._404.cosmos.springpicnic.scenario.entity.Scenario
import com._404.cosmos.springpicnic.scenario.repository.ScenarioRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@Suppress("No" +
        "nAsciiCharacters", "TestFunctionName")
@DataJpaTest
class ScenarioTests {

    @Autowired
    lateinit var scenarioRepository: ScenarioRepository

    val scenario1: Scenario = Scenario(id=1, gameSpan = 10, loadSize = 20)
    val scenario2: Scenario = Scenario(id=2, gameSpan = 15, loadSize = 30)

    @BeforeEach
    fun setUp(){
        scenarioRepository.deleteAll()
    }

    @Test
    fun 시나리오를_추가_한다(){
        scenarioRepository.save(scenario1)

        Assertions.assertEquals(1, scenarioRepository.count())
    }

    @Test
    fun 존재하지_않는_시나리오를_조회_한다(){
        val scenario = scenarioRepository.findById(-1)
        Assertions.assertFalse(scenario.isPresent)
    }

    @Test
    fun 시나리오를_추가_및_조회_한다(){
        scenarioRepository.save(scenario1)
        scenarioRepository.save(scenario2)

        Assertions.assertEquals(2, scenarioRepository.count())

        var scenario = scenarioRepository.findById(scenario1.id!!)
        Assertions.assertTrue(scenario.isPresent)

        isSameScenario(scenario1, scenario.get())

        scenario = scenarioRepository.findById(scenario2.id!!)
        Assertions.assertTrue(scenario.isPresent)

        isSameScenario(scenario2, scenario.get())

    }

    @Test
    fun 모든_데이터를_지운다(){
        scenarioRepository.deleteAll()
        Assertions.assertEquals(0, scenarioRepository.count())
    }

    fun isSameScenario( scenario_a: Scenario,  scenario_b: Scenario){
        Assertions.assertEquals(scenario_a.id, scenario_b.id)
        Assertions.assertEquals(scenario_a.gameSpan, scenario_b.gameSpan)
        Assertions.assertEquals(scenario_a.loadSize, scenario_b.loadSize)
    }

}