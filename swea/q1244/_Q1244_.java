package swea.q1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1244_ {
    static int[] numbers;
    static int limit;
    static int result;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("codingtest/src/swea/q1244/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            StringBuilder stringBuilder = new StringBuilder(String.format("#%d", testCase) + " ");
            String numbersInput = stringTokenizer.nextToken();
            numbers = new int[numbersInput.length()];
            limit = Integer.parseInt(stringTokenizer.nextToken());
            if (limit > numbersInput.length()) {
                limit = numbersInput.length();
            }
            for (int i = 0; i < numbersInput.length(); i++) {
                numbers[i] = Character.getNumericValue(numbersInput.charAt(i));
            }
            result = 0;
            dfs(0);
            stringBuilder.append(result);
            System.out.println(stringBuilder);
        }
    }

    public static void dfs(int count) {
        if (count == limit) {
            StringBuilder tmp = new StringBuilder();
            for (int number : numbers) {
                tmp.append(number);
            }
            result = Math.max(result, Integer.parseInt(tmp.toString()));
            return;
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int tmp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = tmp;
                dfs(count + 1);
                numbers[j] = numbers[i];
                numbers[i] = tmp;
            }
        }
    }
}
