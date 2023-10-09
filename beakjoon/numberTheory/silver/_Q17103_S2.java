package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q17103_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        boolean[] isNotPrimes = new boolean[1_000_001];
        setPrimes(isNotPrimes);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int cnt = 0;
            for (int j = 2; j <= N / 2 ; j++) {
                if (!isNotPrimes[j] && !isNotPrimes[N - j])
                    cnt += 1;
            }
            stringBuilder.append(cnt).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void setPrimes(boolean[] isNotPrimes){
        isNotPrimes[0] = isNotPrimes[1] = true;
        for (int i = 2; i * i <= 1_000_000 ; i++) {
            for (int j = i * i; j <= 1_000_000 ; j += i) {
                if (!isNotPrimes[j])
                    isNotPrimes[j] = true;
            }
        }
    }
}
