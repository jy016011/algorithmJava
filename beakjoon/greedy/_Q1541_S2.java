package beakjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1541_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] subs = bufferedReader.readLine().split("-");
        int answer = -1;
        for (int i = 0; i < subs.length; i++) {
            String[] adds = subs[i].split("\\+");
            int sum = 0;
            for (String add : adds) {
                sum += Integer.parseInt(add);
            }
            if (i == 0)
                answer = sum;
            else
                answer -= sum;
        }
        System.out.println(answer);
    }
}
