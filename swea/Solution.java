package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, P, result;
    static int[] first, second;
    static boolean[] firstVisited, secondVisited;
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 1; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(stringTokenizer.nextToken());
            P = Integer.parseInt(stringTokenizer.nextToken());
            first = new int[N + 1];
            second = new int[N + 1];
            firstVisited = new boolean[N + 1];
            secondVisited = new boolean[N + 1];
            result = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 1; i < N + 1; i++) {
                first[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 1; i < N + 1; i++) {
                second[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            dfs(1, 0, 0);
            System.out.println(result);
        }
    }

    public static void dfs(int idx, int depth, int sum){
        if (depth == N){
            result = Math.max(result, sum);
            return;
        }
        int firstSum = first[idx];
        int secondSum = second[idx];
        if (firstVisited[idx - 1]){
            firstSum -= P;
        }
        if (secondVisited[idx - 1]){
            secondSum -= P;
        }
        firstVisited[idx] = true;
        dfs(idx + 1, depth + 1, sum + firstSum);
        firstVisited[idx] = false;
        secondVisited[idx] = true;
        dfs(idx + 1, depth + 1, sum + secondSum);
        secondVisited[idx] = false;
    }
}
