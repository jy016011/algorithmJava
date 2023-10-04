package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _Q10815_S5_HashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashSet<Integer> cardSet = new HashSet<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cardSet.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            if (cardSet.contains(target))
                stringBuilder.append(1).append(" ");
            else
                stringBuilder.append(0).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
