package com._404.cosmos.domain;

import com._404.cosmos.IntegrationSupport;
import com._404.cosmos.repository.JpaTestModelRepository;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class JpaTestDomainTests extends IntegrationSupport {

    private final JpaTestModelRepository jpaTestModelRepository;

    @Autowired
    public JpaTestDomainTests(JpaTestModelRepository jpaTestModelRepository) {
        this.jpaTestModelRepository = jpaTestModelRepository;
    }

    private final String name = "bvba";

    @BeforeEach
    public void init() {
        JpaTestModel JPATestModel = JpaTestModel.builder().name(name).build();

        jpaTestModelRepository.save(JPATestModel);
    }

    @DisplayName("JPA 연동 및 객체 조회 테스트")
    @Test
    void jpaConnectAndFindTest() {
        Truth.assertThat(jpaTestModelRepository.findByName(name).getName()).isEqualTo(name);
    }

}
