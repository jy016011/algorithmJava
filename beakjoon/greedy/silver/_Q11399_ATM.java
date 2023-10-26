package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11399_ATM {
    static int MAXTIME = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        countingSort(times);
        for (int i = 0; i < n; i++) {
            sum += times[i];
            times[i] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += times[i];
        }
        System.out.println(sum);
    }
    public static void countingSort(int[] numbers){
        int[] counts = new int[MAXTIME + 1];
        int idx = 0;
        for (int number:
             numbers) {
            counts[number] += 1;
        }
        for (int i = 1; i <= MAXTIME ; i++) {
            if (idx == numbers.length) break;
            if (counts[i] > 0){
                for (int j = 1; j <= counts[i]; j++) {
                    numbers[idx] = i;
                    idx++;
                }
            }
        }
    }
}
