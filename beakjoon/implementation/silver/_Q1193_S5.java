package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1193_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int X = Integer.parseInt(br.readLine());
        int offsetSum = 2;
        int sumOfIdx = 2;
        while (offsetSum <= X){
            sumOfIdx++;
            offsetSum += sumOfIdx - 1;
        }
        if (sumOfIdx == 2){ // X == 1
            sb.append("1/1");
        } else if (sumOfIdx % 2 == 0) {// X == even: 아래로 이동
            sb.append(offsetSum - X).append("/");
            sb.append(X - offsetSum + sumOfIdx);
        }
        else { // X == odd: 위로 이동
            sb.append(X - offsetSum + sumOfIdx).append("/");
            sb.append(offsetSum - X);
        }
        System.out.println(sb);
    }
}
