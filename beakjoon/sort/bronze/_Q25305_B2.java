package beakjoon.sort.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q25305_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] scores = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                if (scores[j] > scores[j + 1]){
                    int tmp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tmp;
                }
            }
        }
        System.out.println(scores[N - k]);
    }
}
