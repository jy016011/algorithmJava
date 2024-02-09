package prgrammers;

import java.util.LinkedList;
import java.util.Queue;

/*
    프로그래머스 PCCP 기출문제 2번: 석유 시추
*/
class _PCCP_2 { // Accuracy and time efficiency test passed

    public static void main(String[] args) {
        _PCCP_2 solved = new _PCCP_2();
        int[][] land = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(solved.solution(land)); // answer: 16
    }

    private int N, M;

    public int solution(int[][] land) {
        int answer = 0;
        N = land.length;
        M = land[0].length;
        boolean[][] visited = new boolean[N][M];
        int[] oils = new int[N * M];
        int oilIndex = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 0) {
                    continue;
                }
                if (!visited[i][j]) {
                    int area = bfs(i, j, land, visited, oilIndex); // get count of squares in oil area of index
                    oils[oilIndex] = area; // store count of squares in oil area of oilIndex
                    oilIndex++;
                }
            }
        }

        for (int y = 0; y < M; y++) {
            int sum = 0;
            boolean[] oilVisited = new boolean[oilIndex];
            for (int x = 0; x < N; x++) {
                if (land[x][y] == 0) {
                    continue;
                }
                if (!oilVisited[land[x][y]]) {
                    oilVisited[land[x][y]] = true;
                    sum += oils[land[x][y]];
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private int bfs(int startX, int startY, int[][] land, boolean visited[][], int index) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int area = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        land[startX][startY] = index;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (!visited[nx][ny] && land[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    land[nx][ny] = index;
                    area++;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return area;
    }
}
