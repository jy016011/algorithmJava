package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1436_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int cnt = 0;
        int number = 666;
        while (cnt < N){
            StringBuilder stringBuilder = new StringBuilder(Integer.toString(number));
            if (stringBuilder.indexOf("666") != -1){
                cnt++;
            }
            number++;
        }
        System.out.println(number - 1);
    }
}