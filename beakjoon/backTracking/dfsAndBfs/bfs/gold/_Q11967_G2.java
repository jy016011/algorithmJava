package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q11967_G2 {
    private static int N, M;
    private static int[][] map, switches;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][N];
        M = Integer.parseInt(stringTokenizer.nextToken());
        switches = new int[M][4];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 4; j++) {
                switches[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        
    }
}
