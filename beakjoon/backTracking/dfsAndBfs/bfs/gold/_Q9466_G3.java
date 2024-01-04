package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q9466_G3 {
    private static int N;
    private static int[] students;
    private static boolean[] visited, done;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for (int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(bufferedReader.readLine());
            students = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int stdNumber = 1; stdNumber <= N; stdNumber++) {
                students[stdNumber] = Integer.parseInt(stringTokenizer.nextToken());
            }
            cnt = 0;
            for (int stdNumber = 1; stdNumber <= N; stdNumber++) {
                if (done[stdNumber]) {
                    continue;
                }
                dfs(stdNumber);
            }
            result.append(N - cnt).append(System.lineSeparator());
        }
        System.out.println(result);
    }

    private static void dfs(int current) {
        if (visited[current]) {
            done[current] = true;
            cnt++;
        } else {
            visited[current] = true;
        }

        if (!done[students[current]]) {
            dfs(students[current]);
        }
        done[current] = true;
    }
}
