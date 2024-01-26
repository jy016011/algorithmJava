package beakjoon.shortTermGrowth.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11401_G1 {
    private static final long P = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long N = Integer.parseInt(stringTokenizer.nextToken());
        long K = Integer.parseInt(stringTokenizer.nextToken());
        long nFactMod = getFactorialMod(N); // N! % P
        long denom = getFactorialMod(N - K) * getFactorialMod(K) % P; // {(n - k)! * k!} % p
//        long denom = ( //[{(n - k)! % P}^(p - 2) * (k! % P)^(p - 2)] % p
//                divideAndConquer(getFactorialMod(N - K), P - 2)
//                        * divideAndConquer(getFactorialMod(K), P - 2)
//        ) % P;
        System.out.println(nFactMod * divideAndConquer(denom, P - 2) % P);
//        System.out.println(nFactMod * denom % P);
    }

    private static long getFactorialMod(long N) {
        long factorialMod = 1L;
        while (N > 1) {
            //factorialMod = (factorialMod * (N % P)) % P;
            factorialMod = (factorialMod * N) % P;
            N--;
        }
        return factorialMod;
    }

    private static long divideAndConquer(long base, long expo) {
        if (expo == 1) {
            return base % P;
        }

        long temp = divideAndConquer(base, expo / 2);

        if (expo % 2 == 1) {
            return (temp * temp) % P * base % P;
        }
        return (temp * temp) % P;
    }
}
