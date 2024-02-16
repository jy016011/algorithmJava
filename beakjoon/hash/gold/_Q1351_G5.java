package beakjoon.hash.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _Q1351_G5 {
    private static final Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long N = Long.parseLong(stringTokenizer.nextToken());
        long P = Long.parseLong(stringTokenizer.nextToken());
        long Q = Long.parseLong(stringTokenizer.nextToken());
        map.put(0L, 1L);
        System.out.println(getA(N, P, Q));
    }

    private static long getA(long N, long P, long Q) {
        if (!map.containsKey(N)) {
            map.put(N, getA(N / P, P, Q) + getA(N / Q, P, Q));
        }

        return map.get(N);
    }
}

