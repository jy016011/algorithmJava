package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q2292_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 1;
        int roomCnt = 1;
        while (sum < N){
            sum += roomCnt * 6; // 1, 7, 19, 37, 61
            roomCnt ++;
        }
        System.out.println(roomCnt);
    }
}
