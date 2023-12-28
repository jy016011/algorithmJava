package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _bruteForce_6 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] a = bufferedReader.readLine().toCharArray();
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            a[i] = toOppositeNumber(a[i]);
            String binaryN = String.valueOf(a);
            max = Math.max(max, Integer.parseInt(binaryN, 2));
            a[i] = toOppositeNumber(a[i]);
        }
        System.out.println(max);
    }

    private static char toOppositeNumber(char digit) {
        if (digit == '1') {
            return '0';
        }
        return '1';
    }
}
