package codeTree.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class FirstHalfOf2024_1 {
    // 0, 1, 2, 3 = 북, 동, 남, 서
    // 1은 이동가능한 벽, 2는 출구, 3은 정령의 위치
    private static int[][][] matrixes = {
            {
                    {0, 2, 0},
                    {1, 3, 1},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {1, 3, 2},
                    {0, 1, 0}
            },
            {
                    {0, 1, 0},
                    {1, 3, 1},
                    {0, 2, 0}
            },
            {
                    {0, 1, 0},
                    {2, 3, 1},
                    {0, 1, 0}
            }
    };
    private static int answer;
    private static int[][] numberMap;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[R + 3][C];
        numberMap = new int[R + 3][C];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int startC = Integer.parseInt(st.nextToken()); // 시작 열
            int startD = Integer.parseInt(st.nextToken()); // 시작 출구 방향
            map = move(map, startC, startD, i + 1);
        }
        System.out.println(answer);
    }

    private static int[][] move(int[][] map, int startC, int startD, int num) {
        int[][] matrix = matrixes[startD];
        int curDir = startD;
        int[] curCenter = {1, startC - 1};
        while (true) {
            int curX = curCenter[0];
            int curY = curCenter[1];

            if (canMoveToSouth(map, curX, curY)) {
                curCenter = new int[]{curX + 1, curY};
            } else if (canMoveToSW(map, curX, curY)) {
                curDir--;
                if (curDir < 0) {
                    curDir = 3;
                }
                matrix = matrixes[curDir];
                curCenter = new int[]{curX + 1, curY - 1};
            } else if (canMoveToSE(map, curX, curY)) {
                curDir++;
                curDir %= 4;
                matrix = matrixes[curDir];
                curCenter = new int[]{curX + 1, curY + 1};
            } else {
                break;
            }

        }
        if (curCenter[0] - 1 < 3) {
            numberMap = new int[map.length][map[0].length];
            return new int[map.length][map[0].length];
        }

        int startX = curCenter[0] - 1;
        int startY = curCenter[1] - 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[startX + i][startY + j] != 0) {
                    continue;
                }
                if (matrix[i][j] != 0) {
                    numberMap[startX + i][startY + j] = num;
                }
                map[startX + i][startY + j] = matrix[i][j];
            }
        }
        bfs(map, curCenter[0], curCenter[1], num);
        return map;
    }

    private static class Node {
        int x, y, num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    private static void bfs(int[][] map, int startX, int startY, int startNum) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[map.length][map[0].length];
        int maxDepth = 0;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY, startNum));
        visited[startX][startY] = true;
        map[startX][startY] = 1;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            maxDepth = Math.max(maxDepth, curX);
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (isOutOfRange(map, nx, ny)) {
                    continue;
                }
                // 같은 골렘 내에서 이동하는 경우
                if (!visited[nx][ny] && numberMap[nx][ny] == cur.num) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, cur.num));
                    // 다음 칸이 방문하지 않았으면서 골렘이 있는 칸이고, 현재 있는 칸이 출구이면서, 다음칸이 현재 골렘과 다른 골렘일 때
                } else if (map[curX][curY] == 2 && !visited[nx][ny] && map[nx][ny] != 0
                        && numberMap[nx][ny] != cur.num) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, numberMap[nx][ny]));
                }
            }
        }
        answer += (maxDepth - 2);
    }

    private static boolean canMoveToSouth(int[][] map, int centerX, int centerY) {
        int nx1 = centerX + 2;
        int ny1 = centerY;
        int nx2 = centerX + 1;
        int ny2 = centerY - 1;
        int nx3 = centerX + 1;
        int ny3 = centerY + 1;

        if (isOutOfRange(map, nx1, ny1) || isOutOfRange(map, nx2, ny2) || isOutOfRange(map, nx3, ny3)) {
            return false;
        }

        return map[nx1][ny1] == 0 && map[nx2][ny2] == 0 && map[nx3][ny3] == 0;
    }

    private static boolean canMoveToSW(int[][] map, int centerX, int centerY) {
        int nx1 = centerX - 1;
        int ny1 = centerY - 1;
        int nx2 = centerX;
        int ny2 = centerY - 2;
        int nx3 = centerX + 1;
        int ny3 = centerY - 1;
        int nx4 = centerX + 1;
        int ny4 = centerY - 2;
        int nx5 = centerX + 2;
        int ny5 = centerY - 1;

        if (
                isOutOfRange(map, nx1, ny1) || isOutOfRange(map, nx2, ny2)
                        || isOutOfRange(map, nx3, ny3) || isOutOfRange(map, nx4, ny4)
                        || isOutOfRange(map, nx5, ny5)
        ) {
            return false;
        }

        return map[nx1][ny1] == 0 && map[nx2][ny2] == 0 && map[nx3][ny3] == 0
                && map[nx4][ny4] == 0 && map[nx5][ny5] == 0;
    }

    private static boolean canMoveToSE(int[][] map, int centerX, int centerY) {
        int nx1 = centerX - 1;
        int ny1 = centerY + 1;
        int nx2 = centerX;
        int ny2 = centerY + 2;
        int nx3 = centerX + 1;
        int ny3 = centerY + 1;
        int nx4 = centerX + 1;
        int ny4 = centerY + 2;
        int nx5 = centerX + 2;
        int ny5 = centerY + 1;

        if (
                isOutOfRange(map, nx1, ny1) || isOutOfRange(map, nx2, ny2)
                        || isOutOfRange(map, nx3, ny3) || isOutOfRange(map, nx4, ny4)
                        || isOutOfRange(map, nx5, ny5)
        ) {
            return false;
        }

        return map[nx1][ny1] == 0 && map[nx2][ny2] == 0 && map[nx3][ny3] == 0
                && map[nx4][ny4] == 0 && map[nx5][ny5] == 0;
    }

    private static boolean isOutOfRange(int[][] map, int x, int y) {
        return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
    }
}
