package com.banksse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BankSseApplicationTests {
    @Autowired
    private BankSseApplication bankSseApplication;

    @Test
    void contextLoads() { assertThat(bankSseApplication).isNotNull();
    }
}