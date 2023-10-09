package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q13909_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int cnt = 0;
        for (int i = 1; i * i <= N ; i++) {
                cnt += 1;
        }
        System.out.println(cnt);
    }
}
