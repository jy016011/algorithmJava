package testDome;

import java.util.LinkedList;
import java.util.Queue;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int rowLength = mapMatrix.length;
        int colLength = mapMatrix[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{fromRow, fromColumn});
        visited[fromRow][fromColumn] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            if (x == toRow && y == toColumn) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= rowLength || ny >= colLength) {
                    continue;
                }
                if (!visited[nx][ny] && mapMatrix[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false},
                {true, true, false},
                {false, true, true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}