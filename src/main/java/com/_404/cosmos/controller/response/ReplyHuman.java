package com._404.cosmos.controller.response;

import lombok.Data;

@Data
public class ReplyHuman {
    private Long id = 0L;
    private Integer startPos = 0;
    private Integer currPos = 0;
    private Integer goalPos = 0;
    private Integer patience = 0;
    private Integer remainTime = 0;
}
