package com.echo.softwaretest.lab1;

public class IPChecker{
    public static void main(String[] args) {
        var li = "127..0.0.1".split("\\.");
        for (String s : li) {
            System.out.println(s);
        }
    }
    /**
     * IPv4 address Checker.
     * Check if a string is a valid IPv4 address.
     */
    public void scanAndCheck() {
        String ip;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please input an IP address:");
        ip = scanner.nextLine();
        System.out.println(check(ip));
        scanner.close();
    }

    public String check(String ip) {
        String[] ipParts = ip.split("\\.");
        if (ipParts.length != 4) {
            // if it is `localhost`, return `IP_ADDRESS`
            if (ip.equals("localhost")) {
                return IPCheckResult.IP_ADDRESS.toString();
            }
            // count . number
            int dotCount = 0;
            for (int i = 0; i < ip.length(); i++) {
                if (ip.charAt(i) == '.') {
                    dotCount++;
                }
            }
            if (dotCount == 3) {
                return IPCheckResult.NOT_IP_ADDRESS_EMPTY_PART.toString();
            }
            return IPCheckResult.NOT_IP_ADDRESS_WRONG_NUMBER_OF_PARTS.toString();
        }
        for (String part : ipParts) {
            if (part == null || part.isEmpty()) {
                return IPCheckResult.NOT_IP_ADDRESS_EMPTY_PART.toString();
            }
            for (int i = 0; i < part.length(); i++) {
                if (!Character.isDigit(part.charAt(i))) {
                    return IPCheckResult.NOT_IP_ADDRESS_NON_DIGIT_PART.toString();
                }
            }
            int partInt = Integer.parseInt(part);
            if (partInt < 0 || partInt > 255) {
                return IPCheckResult.NOT_IP_ADDRESS_PART_OUT_OF_RANGE.toString();
            }
        }
        return IPCheckResult.IP_ADDRESS.toString();
    }
}


