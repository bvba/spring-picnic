package com._404.cosmos.controller;

import com._404.cosmos.IntegrationSupport;
import com._404.cosmos.controller.request.ReqHuman;
import com._404.cosmos.controller.request.ReqSimulate;
import com._404.cosmos.controller.request.ReqStart;
import com._404.cosmos.controller.response.*;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.Min;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameControllerTests extends IntegrationSupport {

	private final GameController gameController;

	@Autowired
	public GameControllerTests(GameController gameController) {
		this.gameController = gameController;
	}

	@DisplayName("humans api 테스트")
	@Test
	void humansTest() {
		// given

		// when
		List<ReplyHuman> humans = gameController.humans(0L, "");

		// then
		Truth.assertThat(humans.isEmpty()).isTrue();
	}

	@DisplayName("trafficLights api 테스트")
	@Test
	void trafficLightsTest() {
		// given

		// when
		List<ReplyTrafficLight> trafficLights = gameController.trafficLights(0L, "");

		// then
		Truth.assertThat(trafficLights.isEmpty()).isTrue();
	}

	@DisplayName("score api 테스트")
	@Test
	void scoreTest() {
		// given

		// when
		ReplyScore score = gameController.score(0L, "");

		// then
		Truth.assertThat(score.getLightOnScore()).isLessThan(1);
		Truth.assertThat(score.getPatienceScore()).isLessThan(1);
	}

	@DisplayName("start api 테스트")
	@Test
	void startTest() {
		// given

		// when
		ReplyStart replyStart = gameController.start(new ReqStart());

		// then
		Truth.assertThat(replyStart.getId()).isAtLeast(0);
	}

	@DisplayName("simulate api 테스트")
	@Test
	void simulateTest() {
		// given

		// when
		ReplySimulate replySimulate = gameController.simulate(new ReqSimulate(Collections.emptyList(), Collections.emptyList()));

		// then
		Truth.assertThat(replySimulate.getHumanResultList().isEmpty()).isTrue();
		Truth.assertThat(replySimulate.getTrafficLightResultList().isEmpty()).isTrue();
	}

	// TODO: @Valid 테스트 하기
	// 테스트하려면 추가적인 작업이 필요함
	// https://stackoverflow.com/questions/29069956/how-to-test-validation-annotations-of-a-class-using-junit

}
