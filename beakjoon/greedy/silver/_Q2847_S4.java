package beakjoon.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2847_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int upperLevelScore = scores[N - 1];
        int cnt = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (scores[i] >= upperLevelScore){
                int offset = scores[i] - upperLevelScore + 1;
                cnt += offset;
                upperLevelScore = scores[i] - offset;
            }
            else {
                upperLevelScore = scores[i];
            }
        }
        System.out.println(cnt);
    }
}
