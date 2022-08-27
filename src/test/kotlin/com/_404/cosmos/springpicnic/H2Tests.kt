package com._404.cosmos.springpicnic

import com._404.cosmos.springpicnic.test.TestEntity
import com._404.cosmos.springpicnic.test.repository.TestRepository
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@Suppress("NonAsciiCharacters", "TestFunctionName")
@DataJpaTest
class H2Tests {

	@Autowired
	lateinit var testRepository: TestRepository
		protected set

	@Test
	fun 데이터_추가와_조회에_성공한다() {
		// given
		val testEntity = TestEntity()

		Assertions.assertThatCode {
			// when
			testRepository.save(testEntity)
		}
			// then
			.doesNotThrowAnyException()


		// when
		val findAll = testRepository.findAll()

		// then
		Assertions.assertThat(findAll).size().isPositive
	}

	@Test
	fun 다른_테스트의_영향을_받지_않는다() {
		// given
		val testEntity = TestEntity()
		testRepository.save(testEntity)

		// when
		val findAll = testRepository.findAll()

		// then
		Assertions.assertThat(findAll).size().isEqualTo(1)

	}

}
