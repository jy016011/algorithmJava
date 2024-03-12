package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q20057_G3 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {-1, 0, 1, 0};
    private static final int LEFT = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;

    private static class Tornado {
        int x, y, N, a;
        int direction, outOfMapCount;

        public Tornado(int N) {
            this.N = N;
            x = N / 2;
            y = N / 2;
            direction = LEFT;
            outOfMapCount = 0;
        }

        public void changeDirection() {
            direction = ++direction % 4;
        }

        public void move(int distance, int[][] map) {
            for (int i = 0; i < distance; i++) {
                x += dx[direction];
                y += dy[direction];
                blowSand(map);
                if (x == 0 && y == 0) {
                    break;
                }
            }
        }

        private void blowSand(int[][] map) {
            int totalSand = map[x][y];
            a = totalSand;
            blowLeft(totalSand, map);
            blowRight(totalSand, map);
            blowBack(totalSand, map);
            blowForward(totalSand, map);
            map[x][y] = 0;
        }

        private void blowForward(int totalSand, int[][] map) {
            int fx2 = x + (dx[direction] * 2);
            int fy2 = y + (dy[direction] * 2);
            int forward2Sand = (totalSand * 5) / 100;
            a -= forward2Sand;
            if (isOutOfMap(fx2, fy2)) {
                outOfMapCount += forward2Sand;
            } else {
                map[fx2][fy2] += forward2Sand;
            }

            int leftDirection = (direction + 1) % 4;
            int flx = x + dx[direction] + dx[leftDirection];
            int fly = y + dy[direction] + dy[leftDirection];
            int forwardSideSand = (totalSand * 10) / 100;
            a -= forwardSideSand;
            if (isOutOfMap(flx, fly)) {
                outOfMapCount += forwardSideSand;
            } else {
                map[flx][fly] += forwardSideSand;
            }

            int rightDirection = (direction + 3) % 4;
            int frx = x + dx[direction] + dx[rightDirection];
            int fry = y + dy[direction] + dy[rightDirection];
            a -= forwardSideSand;
            if (isOutOfMap(frx, fry)) {
                outOfMapCount += forwardSideSand;
            } else {
                map[frx][fry] += forwardSideSand;
            }

            int fx1 = x + dx[direction];
            int fy1 = y + dy[direction];
            int forward1Sand = a;
            if (isOutOfMap(fx1, fy1)) {
                outOfMapCount += forward1Sand;
            } else {
                map[fx1][fy1] += forward1Sand;
            }
        }

        private void blowBack(int totalSand, int[][] map) {
            int backDirection = (direction + 2) % 4;
            int leftDirection = (direction + 1) % 4;
            int rightDirection = (direction + 3) % 4;

            int blx = x + dx[backDirection] + dx[leftDirection];
            int bly = y + dy[backDirection] + dy[leftDirection];
            int curSand = totalSand / 100;
            a -= curSand;
            if (isOutOfMap(blx, bly)) {
                outOfMapCount += curSand;
            } else {
                map[blx][bly] += curSand;
            }

            int brx = x + dx[backDirection] + dx[rightDirection];
            int bry = y + dy[backDirection] + dy[rightDirection];
            a -= curSand;
            if (isOutOfMap(brx, bry)) {
                outOfMapCount += curSand;
            } else {
                map[brx][bry] += curSand;
            }
        }

        private void blowLeft(int totalSand, int[][] map) {
            int leftDirection = (direction + 1) % 4;

            int lx1 = x + dx[leftDirection];
            int ly1 = y + dy[leftDirection];
            int left1Sand = (totalSand * 7) / 100;
            a -= left1Sand;
            if (isOutOfMap(lx1, ly1)) {
                outOfMapCount += left1Sand;
            } else {
                map[lx1][ly1] += left1Sand;
            }

            int lx2 = x + (dx[leftDirection] * 2);
            int ly2 = y + (dy[leftDirection] * 2);
            int left2Sand = (totalSand * 2) / 100;
            a -= left2Sand;
            if (isOutOfMap(lx2, ly2)) {
                outOfMapCount += left2Sand;
            } else {
                map[lx2][ly2] += left2Sand;
            }
        }

        private void blowRight(int totalSand, int[][] map) {
            int rightDirection = (direction + 3) % 4;
            int rx1 = x + dx[rightDirection];
            int ry1 = y + dy[rightDirection];
            int right1Sand = (totalSand * 7) / 100;
            a -= right1Sand;
            if (isOutOfMap(rx1, ry1)) {
                outOfMapCount += right1Sand;
            } else {
                map[rx1][ry1] += right1Sand;
            }

            int rx2 = x + (dx[rightDirection] * 2);
            int ry2 = y + (dy[rightDirection] * 2);
            int right2Sand = (totalSand * 2) / 100;
            a -= right2Sand;
            if (isOutOfMap(rx2, ry2)) {
                outOfMapCount += right2Sand;
            } else {
                map[rx2][ry2] += right2Sand;
            }
        }

        private boolean isOutOfMap(int nx, int ny) {
            return (nx < 0 || ny < 0 || nx >= N || ny >= N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        Tornado tornado = new Tornado(N);
        int dirCount = 0;
        int distance = 1;
        while (tornado.x != 0 || tornado.y != 0) {
            tornado.move(distance, map);
            tornado.changeDirection();
            dirCount++;
            if (dirCount % 2 == 0) {
                distance++;
            }
        }
        System.out.println(tornado.outOfMapCount);
    }
}
