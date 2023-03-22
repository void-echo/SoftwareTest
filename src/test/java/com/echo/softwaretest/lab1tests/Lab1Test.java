package com.echo.softwaretest.lab1tests;

import com.echo.softwaretest.lab1.IPCheckResult;
import com.echo.softwaretest.lab1.IPChecker;
import com.echo.softwaretest.lab1.TriangleCheckResult;
import com.echo.softwaretest.lab1.TriangleChecker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Lab1Test {

    @Test
    public void testIPChecker() {
        IPChecker ipChecker = new IPChecker();
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("127.0.0.1"));
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("localhost"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("127.0.0.0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_EMPTY_PART.toString(), ipChecker.check("127..0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("127.0.0.a"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString(), ipChecker.check("127.0.0.256"));
    }

    @Test
    public void testTriangleChecker() {
        TriangleChecker triangleChecker = new TriangleChecker();
        assertEquals(TriangleCheckResult.EQUILATERAL.toString(), triangleChecker.check(1, 1, 1));
        assertEquals(TriangleCheckResult.ISOSCELES.toString(), triangleChecker.check(2, 2, 3));
        assertEquals(TriangleCheckResult.SCALENE.toString(), triangleChecker.check(5, 4, 3));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(-1, 1, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString(), triangleChecker.check(1, 1, 3));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_BIGGER_THAN_UPPER_BOUND.toString(), triangleChecker.check(2000, 1990, 2010));
    }
}
