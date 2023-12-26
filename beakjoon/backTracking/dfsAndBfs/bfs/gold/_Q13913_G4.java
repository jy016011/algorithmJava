package beakjoon.backTracking.dfsAndBfs.bfs.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _Q13913_G4 {
    private static final int[] map = new int[100_001];
    private static final int[] before = new int[100_001];
    private static final boolean[] visited = new boolean[100_001];
    private static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        bfs();
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;
        while (index != N) {
            stack.push(before[index]);
            index = before[index];
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop()).append(" ");
        }
        System.out.println(map[K]);
        System.out.println(stringBuilder);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 2};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        visited[N] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == K) {
                return;
            }
            int next;
            for (int i = 0; i < 3; i++) {
                if (dx[i] == 2) {
                    next = current * dx[i];
                } else {
                    next = current + dx[i];
                }

                if (next < 0 || next > 100_000 || visited[next]) {
                    continue;
                }
                queue.offer(next);
                visited[next] = true;
                map[next] = map[current] + 1;
                before[next] = current;
            }
        }
    }
}
