package swea.q1767;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    private static class Exynos {
        int x, y;

        public Exynos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer, maxConnected, wireLength, connectCount;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("codingtest/src/swea/q1767/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder results = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            answer = N * N;
            maxConnected = 0;
            List<Exynos> exynoses = new ArrayList<>();
            for (int x = 0; x < N; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int y = 0; y < N; y++) {
                    map[x][y] = Integer.parseInt(st.nextToken());
                    // 가장자리인 경우는 엑시노스 셀을 추가하지 않음
                    if (x == 0 || y == 0 || x == N - 1 || y == N - 1) {
                        continue;
                    }
                    if (map[x][y] == 1) {
                        exynoses.add(new Exynos(x, y));
                    }
                }
            }
            search(0, exynoses, map);
            results.append(String.format("#%d %d", test_case, answer)).append(System.lineSeparator());
        }
        System.out.println(results);
    }

    private static void search(int depth, List<Exynos> exynoses, int[][] map) {
        if (depth == exynoses.size()) {
            // 최대 전원 연결 수 갱신시, 전선의 길이 갱신
            if (connectCount > maxConnected) {
                maxConnected = connectCount;
                answer = wireLength;
                // 최대 전원 연결 수와 같을시, 전선의 길이 최소값으로 갱신
            } else if (connectCount == maxConnected) {
                answer = Math.min(answer, wireLength);
            }
            return;
        }
        Exynos cur = exynoses.get(depth);

        fillUp(depth, map, exynoses, cur);

        fillDown(depth, map, exynoses, cur);

        fillLeft(depth, map, exynoses, cur);

        fillRight(depth, map, exynoses, cur);
    }

    private static void fillUp(int depth, int[][] map, List<Exynos> exynoses, Exynos exynos) {
        boolean success = true;
        for (int x = exynos.x - 1; x > -1; x--) {
            // 엑시노스 셀을 만나거나, 다른 전선과 겹치는 경우
            if (map[x][exynos.y] != 0) {
                // 지금까지 그은 전선들 지움
                for (int i = exynos.x - 1; i > x; i--) {
                    map[i][exynos.y] = 0;
                    wireLength--;
                }
                success = false;
                break;
            }
            map[x][exynos.y] = 2;
            wireLength++;
        }
        // 전선을 성공적으로 전원까지 연결했을 경우, 연결 갯수를 셈
        if (success) {
            connectCount++;
        }
        search(depth + 1, exynoses, map);
        // 전선을 전원에 연결 실패하는 경우, 전선 회수 및 연결 수 셈 철회를 할 필요 없음
        if (!success) {
            return;
        }
        // 전선을 전원에 연결 성공한 경우, 전선을 회수하고, 연결 수 셈을 철회
        for (int x = exynos.x - 1; x > -1; x--) {
            map[x][exynos.y] = 0;
            wireLength--;
        }
        connectCount--;
    }

    private static void fillDown(int depth, int[][] map, List<Exynos> exynoses, Exynos exynos) {
        boolean success = true;
        for (int x = exynos.x + 1; x < map.length; x++) {
            if (map[x][exynos.y] != 0) {
                for (int i = exynos.x + 1; i < x; i++) {
                    map[i][exynos.y] = 0;
                    wireLength--;
                }
                success = false;
                break;
            }
            map[x][exynos.y] = 2;
            wireLength++;
        }
        if (success) {
            connectCount++;
        }
        search(depth + 1, exynoses, map);
        if (!success) {
            return;
        }
        for (int x = exynos.x + 1; x < map.length; x++) {
            map[x][exynos.y] = 0;
            wireLength--;
        }
        connectCount--;
    }


    private static void fillLeft(int depth, int[][] map, List<Exynos> exynoses, Exynos exynos) {
        boolean success = true;
        for (int y = exynos.y - 1; y > -1; y--) {
            if (map[exynos.x][y] != 0) {
                for (int i = exynos.y - 1; i > y; i--) {
                    map[exynos.x][i] = 0;
                    wireLength--;
                }
                success = false;
                break;
            }
            map[exynos.x][y] = 2;
            wireLength++;
        }
        if (success) {
            connectCount++;
        }
        search(depth + 1, exynoses, map);
        if (!success) {
            return;
        }
        for (int y = exynos.y - 1; y > -1; y--) {
            map[exynos.x][y] = 0;
            wireLength--;
        }
        connectCount--;
    }


    private static void fillRight(int depth, int[][] map, List<Exynos> exynoses, Exynos exynos) {
        boolean success = true;
        for (int y = exynos.y + 1; y < map[0].length; y++) {
            if (map[exynos.x][y] != 0) {
                for (int i = exynos.y + 1; i < y; i++) {
                    map[exynos.x][i] = 0;
                    wireLength--;
                }
                success = false;
                break;
            }
            map[exynos.x][y] = 2;
            wireLength++;
        }
        if (success) {
            connectCount++;
        }
        search(depth + 1, exynoses, map);
        if (!success) {
            return;
        }
        for (int y = exynos.y + 1; y < map[0].length; y++) {
            map[exynos.x][y] = 0;
            wireLength--;
        }
        connectCount--;
    }
}