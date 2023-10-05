package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _Q10816_S4_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, Integer> cards = new HashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int cardNum = Integer.parseInt(stringTokenizer.nextToken());
            if (cards.containsKey(cardNum))
                cards.put(cardNum, cards.get(cardNum) + 1);
            else
                cards.put(cardNum, 1);
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int cardNum = Integer.parseInt(stringTokenizer.nextToken());
            if (cards.containsKey(cardNum))
                stringBuilder.append(cards.get(cardNum)).append(" ");
            else
                stringBuilder.append(0).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
