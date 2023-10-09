package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q4948_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true){
            int num = Integer.parseInt(bufferedReader.readLine());
            if (num == 0) break;
            stringBuilder.append(countPrimes(num)).append("\n");
        }
        System.out.println(stringBuilder);
    }
    public static int countPrimes(int n){
        boolean[] isNotPrime = new boolean[n * 2 + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        int cnt = 0;
        for (int i = 2; i * i <= n * 2; i++) {
            for (int j = i * i; j <= n * 2 ; j += i) {
                if (!isNotPrime[j])
                    isNotPrime[j] = true;
            }
        }
        for (int i = n + 1; i <= n * 2 ; i++) {
            if (!isNotPrime[i])
                cnt += 1;
        }
        return cnt;
    }
}
