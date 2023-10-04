package beakjoon.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2798_BruteForce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int result = 0;
        int minSub = sum;
        int cardSum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numbers.length ; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    cardSum = numbers[i] + numbers[j] + numbers[k];
                    if (cardSum <= sum && minSub > (sum - cardSum)){
                        result = cardSum;
                        minSub = sum - cardSum;
                    }
                }
            }

        }
        System.out.println(result);
    }
}