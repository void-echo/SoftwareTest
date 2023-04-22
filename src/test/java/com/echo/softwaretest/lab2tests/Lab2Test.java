package com.echo.softwaretest.lab2tests;
import com.echo.softwaretest.lab2.PrimeChecker;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.math3.primes.Primes;

import static org.apache.commons.math3.primes.Primes.isPrime;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
public class Lab2Test {

    @NotNull
    public static String findRealPrimesSmallerThan(int n, int limit) {
        // find biggest limit primes smaller than n
        int[] primes = new int[limit];
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            if (isPrime(i)) {
                primes[count++] = i;
                if (count == limit) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        // reverse order printing, interval with '   '
        int[] toPrint = new int[limit];
        for (int i = limit - 1; i >= 0; i--) {
            toPrint[limit - 1 - i] = primes[i];
        }
        for (int i = limit - 1; i >= 0; i--) {
            sb.append(toPrint[i]).append("   ");
        }
        return sb.toString().trim();
    }
    public static String findRealPrimesSmallerThan(int n) {
        return findRealPrimesSmallerThan(n, 10);
    }

    public static String groundTruth(int n) {
        return findRealPrimesSmallerThan(n, 10);
    }

    @Test
    public void testApachePrime() {
        int n = 229;
        String result = findRealPrimesSmallerThan(n);
        System.out.println(result);
    }
    @Test
    public void testFindingPrime() throws IOException {
        PrimeChecker primeChecker = new PrimeChecker();
        assertEquals(groundTruth(229), primeChecker.check(229));

    }

    public static void main(String[] args) throws IOException{
        int n = 229;
        String result = findRealPrimesSmallerThan(n);
        System.out.println(result);
        System.out.println(isPrime(n));

        PrimeChecker primeChecker = new PrimeChecker();
        System.out.println(primeChecker.check(n));
    }
}
