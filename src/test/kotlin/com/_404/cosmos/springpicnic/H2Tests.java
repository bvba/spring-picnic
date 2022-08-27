package com._404.cosmos.springpicnic;

import com._404.cosmos.springpicnic.test.TestEntity;
import com._404.cosmos.springpicnic.test.repository.TestRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class H2Tests {

    @Autowired
    private TestRepository testRepository;

    @DisplayName("insert, select")
    @Test
    void insertAndSelectTest() {
        final TestEntity entity = new TestEntity();

        testRepository.save(entity);

        final List<TestEntity> all = testRepository.findAll();

        Assertions.assertThat(all).size().isPositive();
    }

    @DisplayName("다른 test의 영향을 받지 않는다.")
    @Test
    void independenceTest() {
        final TestEntity entity = new TestEntity();

        testRepository.save(entity);

        final List<TestEntity> all = testRepository.findAll();

        Assertions.assertThat(all).size().isEqualTo(1);
    }


}
