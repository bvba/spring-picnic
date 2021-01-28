package com._404.cosmos.controller.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ReqTrafficLight {
    @Min(1)
    private Long id;
    private Boolean turn;
}