package swea.q1206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _Q1206_ {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int T = 10;
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int result = 0;
            int[] heights = new int[N];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                heights[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            for (int j = 2; j < N - 2; j++) {
                if (haveViewAtLeft(heights, j) && haveViewAtRight(heights, j)){
                    result += (heights[j] - Math.max(Math.max(heights[j - 1], heights[j - 2]), Math.max(heights[j + 1], heights[j + 2])));
                }
            }
            stringBuilder.append("#").append(i)
                    .append(" ").append(result)
                    .append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static boolean haveViewAtRight(int[] heights, int pivot){
        return heights[pivot] > heights[pivot + 1] && heights[pivot] > heights[pivot + 2];
    }

    public static boolean haveViewAtLeft(int[] heights, int pivot){
        return heights[pivot] > heights[pivot - 1] && heights[pivot] > heights[pivot - 2];
    }
}
