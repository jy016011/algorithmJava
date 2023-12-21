package beakjoon.backTracking.dfsAndBfs.bfs.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178_Bfs {
    static int[][] maze;
    static boolean[][] visited;
    static int row, col;
    static int[] dx = {1, 0, -1, 0}; // down and up
    static int[] dy = {0, 1, 0, -1}; // right and left

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        maze = new int[row + 2][col + 2]; // 2 row and 2 cols for zero padding
        visited = new boolean[row + 2][col + 2];
        for (int i = 1; i < row + 1; i++) {
            sb.append("0").append(br.readLine()).append("0");
            for (int j = 1; j < col + 1; j++) {
                maze[i][j] = sb.charAt(j) - '0';
            }
            sb.setLength(0);
        }
        bfs(1, 1);
        System.out.println(maze[row][col]);
    }

    public static void bfs(int startRow, int startCol) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startRow, startCol});
        maze[startRow][startCol] = 1;
        visited[startRow][startCol] = true;
        while (!q.isEmpty()) {
            int[] idxs = q.poll();
            int x = idxs[0];
            int y = idxs[1];
            if (x == row && y == col) {
                break;
            }
            for (int i = 0; i < 4; i++) {// down -> right -> up -> left
                if ((maze[x + dx[i]][y + dy[i]] == 1) && (!visited[x + dx[i]][y + dy[i]])) {
                    maze[x + dx[i]][y + dy[i]] += maze[x][y];
                    visited[x + dx[i]][y + dy[i]] = true;
                    q.offer(new int[]{x + dx[i], y + dy[i]});
                }
            }
        }
    }
}
