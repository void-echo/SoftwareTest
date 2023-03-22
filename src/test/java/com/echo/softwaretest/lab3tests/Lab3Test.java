package com.echo.softwaretest.lab3tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings("ConstantValue")
@SpringBootTest
public class Lab3Test {

    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    @Test
    public void testLowerCase() {
        assertEquals("hello world", lowerCase("Hello World"));
        assertNull(lowerCase(null));
    }

    @Test
    public void testTrimToEmpty() {
        assertEquals("hello world", trimToEmpty(" hello world "));
        assertEquals("", trimToEmpty(null));
    }
}
