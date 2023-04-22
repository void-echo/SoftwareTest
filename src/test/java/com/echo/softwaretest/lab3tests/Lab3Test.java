package com.echo.softwaretest.lab3tests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ConstantValue")
@SpringBootTest
public class Lab3Test {

    public static String lowerCase(String str) {
        return str == null ? null : str.toLowerCase();
    }


    @Test
    public void testLowerCase() {
        assertEquals("hello world", lowerCase("Hello World"));
        assertNull(lowerCase(null));
    }

    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }


    @Test
    public void testTrimToEmpty() {
        assertEquals("", trimToEmpty(null));
        assertEquals("", trimToEmpty(""));
        assertEquals("", trimToEmpty("   "));
        assertEquals("hello", trimToEmpty("  hell0  "));
        assertEquals("hello", trimToEmpty("hello"));
        assertEquals("hello", trimToEmpty("hello  "));
        assertEquals("hello", trimToEmpty("  hello"));
        assertNotEquals("hello", trimToEmpty("HELLO  "));
        assertNotEquals("hello", trimToEmpty("  HELLO"));
    }
}
