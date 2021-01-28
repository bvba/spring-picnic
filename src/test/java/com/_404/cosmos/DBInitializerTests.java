package com._404.cosmos;

import com._404.cosmos.repository.JpaTestModelRepository;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class DBInitializerTests extends IntegrationSupport {

    private final JpaTestModelRepository jpaTestModelRepository;

    @Autowired
    public DBInitializerTests(JpaTestModelRepository jpaTestModelRepository) {
        this.jpaTestModelRepository = jpaTestModelRepository;
    }

    @DisplayName("초기 로컬 DB 생성 테스트")
    @Test
    void dbInitializerTest() {
        Truth.assertThat(jpaTestModelRepository.findAll().size()).isGreaterThan(0);
    }
}
