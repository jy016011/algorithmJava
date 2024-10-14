package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class withoutAutocomplete {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder results = new StringBuilder();
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] coods = new int[N];
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }
}
