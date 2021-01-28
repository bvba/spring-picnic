package com._404.cosmos.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
@AllArgsConstructor
public class ReqSimulate {
	private List<@Valid ReqHuman> humanList;
	private List<@Valid ReqTrafficLight> trafficLightList;
}
