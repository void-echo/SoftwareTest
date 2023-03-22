package com.echo.softwaretest.lab1;

public class TriangleChecker {
    public static final int upperBound = 1000;

    public String check(int a, int b, int c) {
        if (a > upperBound || b > upperBound || c > upperBound) {
            return TriangleCheckResult.NOT_A_TRIANGLE_SIDE_BIGGER_THAN_UPPER_BOUND.toString();
        }
        // if any negative, return "not a triangle"
        if (a <= 0 || b <= 0 || c <= 0) {
            return TriangleCheckResult.NOT_A_TRIANGLE_NEGATIVE_SIDE.toString();
        }
        // if any side is greater or equal than the sum of the other two, return "not a triangle: side too long"
        if (a >= b + c || b >= a + c || c >= a + b) {
            return TriangleCheckResult.NOT_A_TRIANGLE_SIDE_TOO_LONG.toString();
        }

        // if all sides are equal, return "equilateral"
        if (a == b && b == c) {
            return TriangleCheckResult.EQUILATERAL.toString();
        }

        // if two sides are equal, return "isosceles"
        if (a == b || b == c || a == c) {
            return TriangleCheckResult.ISOSCELES.toString();
        }

        // if none of the above, return "scalene"
        return TriangleCheckResult.SCALENE.toString();
    }

    public void scanAndCheck() {
        int a, b, c;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please input three integers as the sides of a triangle:");
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        System.out.println(check(a, b, c));
        scanner.close();
    }
}

