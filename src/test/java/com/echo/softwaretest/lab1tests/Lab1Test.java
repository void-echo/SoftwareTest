package com.echo.softwaretest.lab1tests;

import com.echo.softwaretest.lab1.IPCheckResult;
import com.echo.softwaretest.lab1.IPChecker;
import com.echo.softwaretest.lab1.TriangleCheckResult;
import com.echo.softwaretest.lab1.TriangleChecker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Lab1Test {

    @Test
    public void testIPCheckerPartitioning() {
        IPChecker ipChecker = new IPChecker();
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("127.0.0.1"));
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("localhost"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString(), ipChecker.check("192.168.0.256"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.-1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192.168.0"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192.168.0.0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_EMPTY_PART.toString(), ipChecker.check("192.168.0."));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192..168.0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.abc"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.-1."));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.-1.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString(), ipChecker.check("192.168.256.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.123 456 789"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check(""));
    }

    @Test
    public void testIPCheckerBoundary() {
        IPChecker ipChecker = new IPChecker();
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("0.0.0.0"));
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("255.255.255.255"));
        assertEquals(IPCheckResult.IP_ADDRESS.toString(), ipChecker.check("localhost"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString(), ipChecker.check("192.168.0.256"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.-1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192.168.0"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192.168.0.0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_EMPTY_PART.toString(), ipChecker.check("192.168.0."));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check("192..168.0.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.abc"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.-1."));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.-1.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString(), ipChecker.check("192.168.256.1"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString(), ipChecker.check("192.168.0.123 456 789"));
        assertEquals(IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString(), ipChecker.check(""));
    }



    @Test
    public void testTriangleCheckerPartitioning() {
        TriangleChecker triangleChecker = new TriangleChecker();
        assertEquals(TriangleCheckResult.EQUILATERAL.toString(), triangleChecker.check(1, 1, 1));
        assertEquals(TriangleCheckResult.ISOSCELES.toString(), triangleChecker.check(2, 2, 1));
        assertEquals(TriangleCheckResult.SCALENE.toString(), triangleChecker.check(3, 4, 5));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(1, 1, 0));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(1, 1, -1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_BIGGER_THAN_UPPER_BOUND.toString(), triangleChecker.check(2000, 1990, 2010));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString(), triangleChecker.check(9, 1, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString(), triangleChecker.check(1, 9, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString(), triangleChecker.check(1, 1, 9));
    }

    @Test
    public void testTriangleCheckerBoundaryValue() {
        TriangleChecker triangleChecker = new TriangleChecker();
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString(), triangleChecker.check(1, 1, 2));
        assertEquals(TriangleCheckResult.ISOSCELES.toString(), triangleChecker.check(1, 2, 2));
        assertEquals(TriangleCheckResult.EQUILATERAL.toString(), triangleChecker.check(2, 2, 2));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(0, 0, 0));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(-1, -1, -1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(0, 1, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(-1, 1, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(0, 0, 1));
        assertEquals(TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString(), triangleChecker.check(-1, -1, 1));
    }
}
