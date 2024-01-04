package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q16920_G2 {
    private static final char empty = '.';
    private static final char wall = '#';
    private static int N, M, P;
    private static char[][] map;
    private static int[] offsets;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[N][M];
        P = Integer.parseInt(stringTokenizer.nextToken());
        offsets = new int[P + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i < P; i++) {
            offsets[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < N; i++) {
            String row = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = row.charAt(j);
            }
        }

    }

}
