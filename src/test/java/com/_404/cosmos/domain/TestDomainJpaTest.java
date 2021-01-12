package com._404.cosmos.domain;

import com._404.cosmos.repository.JpaTestModelRepository;
import com.google.common.truth.Truth;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestDomainJpaTest {

    @Autowired
    public JpaTestModelRepository jpaTestModelRepository;

    private final String name = "bvba";

    @Before
    public void init() {
        JpaTestModel JPATestModel = JpaTestModel.builder().name(name).build();

        jpaTestModelRepository.save(JPATestModel);
    }

    @Test
    public void JPA_연동_및_객체_조회_테스트() {
        Truth.assertThat(jpaTestModelRepository.findByName(name).getName()).isEqualTo(name);
    }

}
