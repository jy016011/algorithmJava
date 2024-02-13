package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Q15683_G4_Improved {
    private static class Cam {
        int x;
        int y;
        int type;

        public Cam(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    private static int N, M, min;
    private static int[][] map;
    private static List<Cam> cams;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        cams = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cams.add(new Cam(i, j, map[i][j]));
                }
            }
        }
        min = N * M;
        getRange(0);
        System.out.println(min);
    }

    private static void getRange(int depth) {
        if (depth == cams.size()) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        count++;
                    }
                }
            }

            min = Math.min(min, count);
            return;
        }

        Cam cam = cams.get(depth);
        if (cam.type == 1) {
            setCam1(cam.x, cam.y, depth);
        } else if (cam.type == 2) {
            setCam2(cam.x, cam.y, depth);
        } else if (cam.type == 3) {
            setCam3(cam.x, cam.y, depth);
        } else if (cam.type == 4) {
            setCam4(cam.x, cam.y, depth);
        } else if (cam.type == 5) {
            setCam5(cam.x, cam.y, depth);
        }
    }

    private static void setCam1(int x, int y, int depth) {
        fillRight(x, y);
        getRange(depth + 1);
        rollBackRight(x, y);

        fillDown(x, y);
        getRange(depth + 1);
        rollBackDown(x, y);

        fillLeft(x, y);
        getRange(depth + 1);
        rollBackLeft(x, y);

        fillUp(x, y);
        getRange(depth + 1);
        rollBackUp(x, y);
    }

    private static void setCam2(int x, int y, int depth) {
        fillLeft(x, y);
        fillRight(x, y);
        getRange(depth + 1);
        rollBackLeft(x, y);
        rollBackRight(x, y);

        fillUp(x, y);
        fillDown(x, y);
        getRange(depth + 1);
        rollBackUp(x, y);
        rollBackDown(x, y);
    }

    private static void setCam3(int x, int y, int depth) {
        fillUp(x, y);
        fillRight(x, y);
        getRange(depth + 1);
        rollBackUp(x, y);

        fillDown(x, y);
        getRange(depth + 1);
        rollBackRight(x, y);

        fillLeft(x, y);
        getRange(depth + 1);
        rollBackDown(x, y);

        fillUp(x, y);
        getRange(depth + 1);
        rollBackLeft(x, y);
        rollBackUp(x, y);
    }

    private static void setCam4(int x, int y, int depth) {
        fillLeft(x, y);
        fillUp(x, y);
        fillRight(x, y);
        getRange(depth + 1);
        rollBackLeft(x, y);

        fillDown(x, y);
        getRange(depth + 1);
        rollBackUp(x, y);

        fillLeft(x, y);
        getRange(depth + 1);
        rollBackRight(x, y);

        fillUp(x, y);
        getRange(depth + 1);
        rollBackDown(x, y);
        rollBackLeft(x, y);
        rollBackUp(x, y);
    }

    private static void setCam5(int x, int y, int depth) {
        fillUp(x, y);
        fillRight(x, y);
        fillDown(x, y);
        fillLeft(x, y);
        getRange(depth + 1);
        rollBackUp(x, y);
        rollBackRight(x, y);
        rollBackDown(x, y);
        rollBackUp(x, y);
    }

    private static void fillUp(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 6) {
                break;
            }
            if (map[i][y] <= 0) {
                map[i][y]--;
            }
        }
    }

    private static void rollBackUp(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 6) {
                break;
            }
            if (map[i][y] < 0) {
                map[i][y]++;
            }
        }
    }

    private static void fillDown(int x, int y) {
        for (int i = x + 1; i < N; i++) {
            if (map[i][y] == 6) {
                break;
            }
            if (map[i][y] <= 0) {
                map[i][y]--;
            }
        }
    }

    private static void rollBackDown(int x, int y) {
        for (int i = x + 1; i < N; i++) {
            if (map[i][y] == 6) {
                break;
            }
            if (map[i][y] < 0) {
                map[i][y]++;
            }
        }
    }

    private static void fillLeft(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 6) {
                break;
            }
            if (map[x][i] <= 0) {
                map[x][i]--;
            }
        }
    }

    private static void rollBackLeft(int x, int y) {
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 6) {
                break;
            }
            if (map[x][i] < 0) {
                map[x][i]++;
            }
        }
    }

    private static void fillRight(int x, int y) {
        for (int i = y + 1; i < M; i++) {
            if (map[x][i] == 6) {
                break;
            }
            if (map[x][i] <= 0) {
                map[x][i]--;
            }
        }
    }

    private static void rollBackRight(int x, int y) {
        for (int i = y + 1; i < M; i++) {
            if (map[x][i] == 6) {
                break;
            }
            if (map[x][i] < 0) {
                map[x][i]++;
            }
        }
    }

}
