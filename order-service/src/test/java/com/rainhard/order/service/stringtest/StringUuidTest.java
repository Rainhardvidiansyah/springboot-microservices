package com.rainhard.order.service.stringtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class StringUuidTest {

    @Test
    void printUuid(){
        String uuid = UUID.randomUUID().toString();
        Assertions.assertNotNull(uuid);
        System.out.println(uuid);
    }
}
