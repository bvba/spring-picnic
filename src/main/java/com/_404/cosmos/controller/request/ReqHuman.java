package com._404.cosmos.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
public class ReqHuman {
    @Min(1)
    private Long id;
    private Integer goal;
}