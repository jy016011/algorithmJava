package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1004_LittlePrince {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] points = new int[2][2]; // for start and end points
            int cnt = 0; // cnt for going in & out circle
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    points[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            int n = Integer.parseInt(br.readLine());
            int[][] circles = new int[n][3];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 3; k++) {
                    circles[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for (int[] circle: circles) {
                int sameArea = 0;
                for (int[] point: points) {
                    if (isInCirce(point, circle)) {
                        cnt += 1;
                        sameArea += 1;
                    }
                    if (sameArea == 2)
                        cnt -= 2;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    public static boolean isInCirce(int[] point, int[] circle){
        return Math.sqrt(Math.pow(circle[0] - point[0], 2) + Math.pow(circle[1] - point[1], 2)) < circle[2];
    }
}
