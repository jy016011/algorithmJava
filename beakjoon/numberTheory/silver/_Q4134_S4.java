package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class _Q4134_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            BigInteger N = new BigInteger(bufferedReader.readLine());
            if (N.isProbablePrime(10))
                stringBuilder.append(N).append("\n");
            else
                stringBuilder.append(N.nextProbablePrime()).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
