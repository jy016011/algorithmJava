package beakjoon.numberTheory.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q13241_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long a = Long.parseLong(stringTokenizer.nextToken());
        long b = Long.parseLong(stringTokenizer.nextToken());
        System.out.println(a * b / getCcd(a, b));
    }
//    public static long getCcd(long a, long b){
//        while (b != 0){
//            long tmp = b;
//            b = a % b;
//            a = tmp;
//        }
//        return a;
//    }
    public static long getCcd(long a, long b){
        if (b == 0)
            return a;
        else return getCcd(b , a % b);
    }
}
