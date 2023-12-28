package codeTree.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _bruteForce_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] checkPoints = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            checkPoints[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            checkPoints[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int curX = checkPoints[0][0];
            int curY = checkPoints[0][1];
            int distance = 0;
            for (int j = 1; j < N; j++) {
                if (j == i) {
                    continue;
                }
                distance += Math.abs(curX - checkPoints[j][0]) + Math.abs(curY - checkPoints[j][1]);
                curX = checkPoints[j][0];
                curY = checkPoints[j][1];
            }
            minDistance = Math.min(minDistance, distance);
        }
        System.out.println(minDistance);
    }
}
