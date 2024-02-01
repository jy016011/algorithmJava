package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class CommuteToWork {
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        List<Integer>[] map = new ArrayList[n + 1];
        List<Integer>[] mapReverse = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
            mapReverse[i] = new ArrayList<>();
        }
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start].add(end);
            mapReverse[end].add(start);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Set<Integer> set1 = bfs(start, end, map);
        Set<Integer> set2 = bfs(end, 0, mapReverse);
        Set<Integer> set3 = bfs(end, start, map);
        Set<Integer> set4 = bfs(start, 0, mapReverse);
        set1.retainAll(set2);
        set3.retainAll(set4);
        set1.retainAll(set3);
        int result = set1.size();

        System.out.println(result);
    }

    private static Set<Integer> bfs(int start, int target, List<Integer>[] map) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == target) {
                continue;
            }
            for (int i = 0; i < map[current].size(); i++) {
                int next = map[current].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        return set;
    }
}
