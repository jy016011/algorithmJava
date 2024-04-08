package swea.q5656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private static int count = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("codingtest/src/swea/q5656/sample_input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int[] coods = new int[N];
            int W = Integer.parseInt(stringTokenizer.nextToken());
            int H = Integer.parseInt(stringTokenizer.nextToken());
            int[][] map = new int[H][W];
            for (int i = 0; i < H; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            getPermutations(0, N, W, coods, map);
            result.append(String.format("#%d %d", test_case, count)).append(System.lineSeparator());
            count = Integer.MAX_VALUE;
        }
        System.out.println(result);
    }

    private static void getPermutations(int depth, int N, int W, int[] coods, int[][] map) {
        if (depth == N) {
            int[][] temp = new int[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            temp = shootMarbles(coods, temp);
            int cnt = 0;
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    if (temp[i][j] != 0) {
                        cnt++;
                    }
                }
            }
            count = Math.min(cnt, count);
            return;
        }
        for (int i = 0; i < W; i++) {
            coods[depth] = i;
            getPermutations(depth + 1, N, W, coods, map);
        }
    }

    private static int[][] shootMarbles(int[] coods, int[][] map) {
        for (int col : coods) {
            map = shootMarble(col, map);
        }
        return map;
    }

    private static int[][] shootMarble(int col, int[][] map) {
        for (int row = 0; row < map.length; row++) {
            if (map[row][col] != 0) {
                popBlock(row, col, map);
                map = gravity(map);
                break;
            }
        }
        return map;
    }

    private static void popBlock(int row, int col, int[][] map) {
        if (isOutOfRange(row, col, map)) {
            return;
        }
        int range = map[row][col];
        if (range == 0) {
            return;
        }
        map[row][col] = 0;
        for (int dr = 1; dr < range; dr++) {
            popBlock(row + dr, col, map);
            popBlock(row - dr, col, map);
            popBlock(row, col + dr, map);
            popBlock(row, col - dr, map);
        }

    }

    private static int[][] gravity(int[][] map) {
        int[][] temp = new int[map.length][map[0].length];
        for (int col = 0; col < map[0].length; col++) {
            int idx = map.length - 1;
            for (int row = map.length - 1; row >= 0; row--) {
                if (map[row][col] == 0) {
                    continue;
                }
                if (temp[idx][col] == 0) {
                    temp[idx--][col] = map[row][col];
                }
            }
        }
        return temp;
    }

    private static boolean isOutOfRange(int x, int y, int[][] map) {
        return x < 0 || y < 0 || x >= map.length || y >= map[0].length;
    }

//        private static void printMap(int[][] map) {
//        for (int[] row :
//                map) {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//    }
}
