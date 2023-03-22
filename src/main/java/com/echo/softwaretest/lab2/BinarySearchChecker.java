package com.echo.softwaretest.lab2;

import java.util.Comparator;
import java.util.List;

public class BinarySearchChecker {
    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public <T> String check(List<? extends Comparable<? super T>> list, T key) {
        if (list == null) {
            return BinarySearchCheckResult.LIST_NULL.toString();
        } else if (list.isEmpty()) {
            return BinarySearchCheckResult.LIST_EMPTY.toString();
        } else if (list.size() == 1) {
            if (list.get(0).compareTo(key) == 0) {
                return BinarySearchCheckResult.FOUND.toString();
            } else {
                return BinarySearchCheckResult.NOT_FOUND.toString();
            }
        } else {
            for (int i = 0; i < list.size() - 1; i++) {
                Object o1 = list.get(i);
                Object o2 = list.get(i + 1);
                assert o1 != null && o2 != null;
                if (((Comparable) o1).compareTo(o2) > 0) {
                    return BinarySearchCheckResult.LIST_NOT_SORTED.toString();
                }
            }
            if (key == null) {
                return BinarySearchCheckResult.INVALID_KEY.toString();
            } else {
                int index = indexedBinarySearch(list, key);
                if (index >= 0) {
                    return BinarySearchCheckResult.FOUND.toString();
                } else {
                    return BinarySearchCheckResult.NOT_FOUND.toString();
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchChecker binarySearchChecker = new BinarySearchChecker();
        System.out.println(binarySearchChecker.check(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 5));
        System.out.println(binarySearchChecker.check(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9), 10));
        System.out.println(binarySearchChecker.check(List.of(1, 2, 3, 4, 5, 6, 7, 9, 9), 10));
        System.out.println(binarySearchChecker.check(List.of(1, 2, 3, 4, 5, 6, 7, 9, 0), 10));
    }
}


