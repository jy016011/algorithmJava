package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2566_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int rowMax = 0;
        int colMax = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int currentNumber = Integer.parseInt(st.nextToken());
                if (max < currentNumber){
                    max = currentNumber;
                    rowMax = i + 1;
                    colMax = j + 1;
                }
            }
        }
        System.out.println(max + "\n" + rowMax +" " + colMax);
    }
}
