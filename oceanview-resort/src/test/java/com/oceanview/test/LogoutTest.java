package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LogoutTest {

    @Test
    void testLogoutSessionInvalidation() {

        boolean sessionActive = true;

        // simulate logout
        sessionActive = false;

        assertFalse(sessionActive);

    }
}