package testDome;

import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int index = Arrays.binarySearch(sortedArray, lessThan);
        if (index < 0) {
            index = Math.abs(index) - 1;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[]{1, 2, 3, 7}, 4));
    }
}
