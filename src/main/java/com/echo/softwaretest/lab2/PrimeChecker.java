package com.echo.softwaretest.lab2;

import java.io.File;
import java.io.IOException;

public class PrimeChecker {
    public static final String dir = "D:\\__CodingProjects\\Java\\SoftwareTest\\src\\main\\java\\com\\echo\\softwaretest\\lab2\\cpp\\";
    public static final String filename = "findPrime.exe";
    public String check(int upperBound) throws IOException {
        // execute binary exe file: ./cpp/findPrime.exe
        Process exec = Runtime.getRuntime().exec(dir + filename, null, new File(dir));
        // write upperBound to stdin
        exec.getOutputStream().write((upperBound + "").getBytes());
        exec.getOutputStream().flush();
        exec.getOutputStream().close();
        // read stdout
        java.util.Scanner scanner = new java.util.Scanner(exec.getInputStream());
        String result = scanner.nextLine();
        scanner.close();
        return result.trim();
    }

    public static void main(String[] args) {
        PrimeChecker primeChecker = new PrimeChecker();
        try {
            System.out.println(primeChecker.check(229));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
