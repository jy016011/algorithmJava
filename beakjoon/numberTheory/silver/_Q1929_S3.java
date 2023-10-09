package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1929_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= N ; i++) {
            for (int j = i * i; j <= N; j += i) {
                if (!isNotPrime[j]){
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = M; i <= N ; i++) {
            if (!isNotPrime[i])
                stringBuilder.append(i).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
