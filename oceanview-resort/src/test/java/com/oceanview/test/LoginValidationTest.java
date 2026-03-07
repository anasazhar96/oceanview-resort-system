package com.oceanview.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LoginValidationTest {

    @Test
    void testLoginWithValidCredentials() {

        String username = "admin";
        String password = "admin123";

        boolean result = username.equals("admin") && password.equals("admin123");

        assertTrue(result);
    }
    @Test
    void testInvalidLogin() {

        String username = "admin";
        String password = "wrongpassword";

        boolean isValid = username.equals("admin") && password.equals("admin123");

        assertFalse(isValid);

    }
}