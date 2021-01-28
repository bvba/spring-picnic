package com._404.cosmos.utils;

import java.util.UUID;

public class TokenCreator {

    private TokenCreator() {
        throw new IllegalStateException("Utility class");
    }

    public static String createToken() {
        return UUID.randomUUID().toString();
    }
}
