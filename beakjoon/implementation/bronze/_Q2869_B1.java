package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2869_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        double daysBeforeLastDay = (double) (V - A) / (A - B);
        if (daysBeforeLastDay % 1.0 == 0.0){// Case for integer
            System.out.println((int)daysBeforeLastDay + 1);
        }
        else System.out.println((int) daysBeforeLastDay + 2); // Case for float
    }
}
