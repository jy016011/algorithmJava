package beakjoon.shortTermGrowth.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1629_S1 {
    private static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        C = Long.parseLong(stringTokenizer.nextToken());
        System.out.println(divideAndConquer(A, B));
    }

    private static long divideAndConquer(int A, int expo) {
        if (expo == 1L) {
            return A % C;
        }

        long temp = divideAndConquer(A, expo / 2);

        if (expo % 2L == 1) {
            return (temp * temp) % C * A % C;
        }

        return (temp * temp) % C;
    }
}
