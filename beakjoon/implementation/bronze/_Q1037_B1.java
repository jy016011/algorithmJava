package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q1037_B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        //ArrayList<Integer> divisors = new ArrayList<>();
        int[] divisors = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            //divisors.add(Integer.parseInt(stringTokenizer.nextToken()));
            divisors[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(divisors);
        System.out.println(divisors[0] * divisors[divisors.length - 1]);
//        divisors.sort(Comparator.naturalOrder());
//        System.out.println(divisors.get(0) * divisors.get(divisors.size() - 1));
    }
}
