package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class _Q14500_G4 {
    private static int N, M;
    private static int[][] map;
    private static final List<int[][]> tetrominos = List.of(
            new int[][]{{1, 1, 1, 1}},
            new int[][]{
                    {1},
                    {1},
                    {1},
                    {1}
            },
            new int[][]{
                    {1, 1},
                    {1, 1}
            },
            new int[][]{
                    {1, 0},
                    {1, 1},
                    {0, 1}
            },
            new int[][]{
                    {0, 1, 1},
                    {1, 1, 0}
            },
            new int[][]{
                    {0, 1},
                    {1, 1},
                    {1, 0}
            },
            new int[][]{
                    {1, 1, 0},
                    {0, 1, 1}
            },
            new int[][]{
                    {1, 1, 1},
                    {0, 1, 0}
            },
            new int[][]{
                    {0, 1},
                    {1, 1},
                    {0, 1}
            },
            new int[][]{
                    {0, 1, 0},
                    {1, 1, 1}
            },
            new int[][]{
                    {1, 0},
                    {1, 1},
                    {1, 0}
            },
            new int[][]{
                    {1, 0},
                    {1, 0},
                    {1, 1}
            },
            new int[][]{
                    {1, 1, 1},
                    {1, 0, 0}
            },
            new int[][]{
                    {1, 1},
                    {0, 1},
                    {0, 1}
            },
            new int[][]{
                    {0, 0, 1},
                    {1, 1, 1}
            },
            new int[][]{
                    {0, 1},
                    {0, 1},
                    {1, 1}}
            ,
            new int[][]{
                    {1, 0, 0},
                    {1, 1, 1}
            },
            new int[][]{
                    {1, 1},
                    {1, 0},
                    {1, 0}
            },
            new int[][]{
                    {1, 1, 1},
                    {0, 0, 1}
            }
    );

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int result = 0;
        for (int[][] tetromino :
                tetrominos) {
            for (int x = 0; x <= N - tetromino.length; x++) {
                for (int y = 0; y <= M - tetromino[0].length; y++) {
                    result = Math.max(result, getSum(x, y, tetromino));
                }
            }
        }
        System.out.println(result);

    }

    private static int getSum(int startX, int startY, int[][] shape) {
        if (startX + shape.length > N || startY + shape[0].length > M) {
            return 0;
        }
        int sum = 0;
        for (int x = startX; x < startX + shape.length; x++) {
            for (int y = startY; y < startY + shape[0].length; y++) {
                sum += (map[x][y] * shape[x - startX][y - startY]);
            }
        }
        return sum;
    }
}
