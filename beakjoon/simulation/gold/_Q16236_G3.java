package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q16236_G3 {
    static class Shark {
        int x, y, size, eat;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            size = 2;
            eat = 0;
        }

        public void move(Node fish, int[][] map) {
            map[this.x][this.y] = 0;
            map[fish.x][fish.y] = 9;
            this.x = fish.x;
            this.y = fish.y;
            eat++;

            if (eat == size) {
                size++;
                eat = 0;
            }
        }
    }

    static class Node {
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return String.format("x: %d, y: %d, distance: %d", x, y, distance);
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[N][N];
        Shark shark = new Shark(0, 0);
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int item = Integer.parseInt(stringTokenizer.nextToken());
                map[i][j] = item;
                if (item == 9) {
                    shark = new Shark(i, j);
                }
            }
        }
        int time = 0;
        while (true) {
            PriorityQueue<Node> fishes = searchFish(shark, map);
            if (fishes.isEmpty()) {
                break;
            }
            Node fish = fishes.poll();
            shark.move(fish, map);
            time += fish.distance;
        }
        System.out.println(time);
    }

    private static PriorityQueue<Node> searchFish(Shark shark, int[][] map) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Node> fishes = new PriorityQueue<>(
                ((o1, o2) -> {
                    if (o1.distance == o2.distance) {
                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        }
                        return o1.x - o2.x;
                    }
                    return o1.distance - o2.distance;
                })
        );
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isOutOfRange(nx, ny)) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != 9 && map[nx][ny] <= shark.size) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, cur.distance + 1));
                    if (map[nx][ny] < shark.size && map[nx][ny] != 0) {
                        fishes.offer(new Node(nx, ny, cur.distance + 1));
                    }
                }
            }
        }
        return fishes;
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}
