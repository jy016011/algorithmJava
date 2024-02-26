package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _Q1911_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int[][] puddles = new int[N][2];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            puddles[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            puddles[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(puddles, (Comparator.comparingInt(o -> o[0])));

        int boxStart = 0;
        int count = 0;
        for (int[] puddle :
                puddles) {
            int puddleStart = puddle[0];
            int puddleEnd = puddle[1];
            int length = puddleEnd - puddleStart;
            int countOfBox = getCountOfBox(length, L);
            if (puddleStart >= boxStart) {
                boxStart = puddleStart + (countOfBox * L);
            } else {
                length = length - (boxStart - puddleStart);
                if (length <= 0) {
                    continue;
                }
                countOfBox = getCountOfBox(length, L);
                boxStart = boxStart + (countOfBox * L);
            }

            count += countOfBox;
        }
        System.out.println(count);
    }

    private static int getCountOfBox(int length, int L) {
        if (length % L == 0) {
            return length / L;
        }
        return length / L + 1;

    }
}
