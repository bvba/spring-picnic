package com._404.cosmos.utils;

import com._404.cosmos.IntegrationSupport;
import com._404.cosmos.repository.JpaTestModelRepository;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

class TokenCreatorTests extends IntegrationSupport {

	@Autowired
	JpaTestModelRepository jpaTestModelRepository;

	@DisplayName("토큰 생성 테스트")
	@Test
	void createTokenTest() {
		Truth.assertThat(StringUtils.isEmpty(TokenCreator.createToken())).isFalse();
	}

	@DisplayName("토큰 중복 테스트")
	@Test
	void tokenDuplicateTest() {
		final int size = 500_000;
		Truth.assertThat((int) Stream.generate(TokenCreator::createToken)
				.limit(size).distinct().count()).isEqualTo(size);
	}

}
