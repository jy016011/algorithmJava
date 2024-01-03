package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
                bfs(stdNumber);
            }
            result.append(cnt).append(System.lineSeparator());
        }
        System.out.println(result);
    }

    private static void bfs(int studentNumber) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(studentNumber);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (visited[current]) {
                done[current] = true;
                cnt++;
            } else {
                visited[current] = true;
            }

            if (!done[students[current]]) {
                queue.offer(students[current]);
                continue;
            }
            visited[current] = false;
            done[current] = true;
        }
    }
}
