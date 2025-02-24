package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Q15683_secondTry {
    private static final int SPACE = 0;
    private static final int WALL = 6;

    private static int answer;

    private static class Camera {
        int type, x, y;

        private Camera(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] camMap = new boolean[N][M];
        List<Camera> cameras = new ArrayList<>();
        int blindSpotCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int e = Integer.parseInt(st.nextToken());
                if (e > SPACE && e < WALL) { // 요소가 CCTV인 경우
                    cameras.add(new Camera(e, i, j));
                    camMap[i][j] = true;
                    continue;
                } else if (e == SPACE) { // 요소가 빈공간인 경우에는 처음에는 사각지대로 셈, CCTV가 감시하는 영역의 수 만큼 빼가며 답을 구함
                    blindSpotCount++; // 감시카메라는 사각지대에서 제외하는 것에 유의
                }
                map[i][j] = e; // 요소가 벽과 빈공간일 경우에는 맵에 표시
            }
        }

        answer = blindSpotCount;
        search(map, camMap, 0, blindSpotCount, cameras);
        System.out.println(answer);
    }

    private static void search(int[][] map, boolean[][] camMap, int index, int blindSpotCount, List<Camera> cameras) {
        if (index == cameras.size()) {
            answer = Math.min(answer, blindSpotCount);
            return;
        }
        Camera currentCam = cameras.get(index);
        if (currentCam.type == 1) {
            searchCam1(map, camMap, cameras, index, blindSpotCount);
        } else if (currentCam.type == 2) {
            searchCam2(map, camMap, cameras, index, blindSpotCount);
        } else if (currentCam.type == 3) {
            searchCam3(map, camMap, cameras, index, blindSpotCount);
        } else if (currentCam.type == 4) {
            searchCam4(map, camMap, cameras, index, blindSpotCount);
        } else if (currentCam.type == 5) {
            searchCam5(map, camMap, cameras, index, blindSpotCount);
        }
    }

    private static void searchCam1(int[][] map, boolean[][] camMap, List<Camera> cameras, int index,
                                   int blindSpotCount) {
        Camera curCam = cameras.get(index);
        int showSpotCount = fillRight(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseRight(map, camMap, curCam.x, curCam.y);

        showSpotCount = fillDown(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseDown(map, camMap, curCam.x, curCam.y);

        showSpotCount = fillLeft(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseLeft(map, camMap, curCam.x, curCam.y);

        showSpotCount = fillUp(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseUp(map, camMap, curCam.x, curCam.y);
    }

    private static void searchCam2(int[][] map, boolean[][] camMap, List<Camera> cameras, int index,
                                   int blindSpotCount) {
        Camera curCam = cameras.get(index);
        int showSpotCount = fillRight(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillLeft(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseRight(map, camMap, curCam.x, curCam.y);
        eraseLeft(map, camMap, curCam.x, curCam.y);

        showSpotCount = fillUp(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillDown(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseUp(map, camMap, curCam.x, curCam.y);
        eraseDown(map, camMap, curCam.x, curCam.y);
    }

    private static void searchCam3(int[][] map, boolean[][] camMap, List<Camera> cameras, int index,
                                   int blindSpotCount) {
        Camera curCam = cameras.get(index);
        int showSpotCount = fillUp(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillRight(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseUp(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillDown(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseRight(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillLeft(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseDown(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillUp(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseLeft(map, camMap, curCam.x, curCam.y);
        eraseUp(map, camMap, curCam.x, curCam.y);
    }

    private static void searchCam4(int[][] map, boolean[][] camMap, List<Camera> cameras, int index,
                                   int blindSpotCount) {
        Camera curCam = cameras.get(index);
        int showSpotCount = fillLeft(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillUp(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillRight(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseLeft(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillDown(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseUp(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillLeft(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        showSpotCount -= eraseRight(map, camMap, curCam.x, curCam.y);

        showSpotCount += fillUp(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseDown(map, camMap, curCam.x, curCam.y);
        eraseLeft(map, camMap, curCam.x, curCam.y);
        eraseUp(map, camMap, curCam.x, curCam.y);
    }

    private static void searchCam5(int[][] map, boolean[][] camMap, List<Camera> cameras, int index,
                                   int blindSpotCount) {
        Camera curCam = cameras.get(index);
        int showSpotCount = fillLeft(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillUp(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillRight(map, camMap, curCam.x, curCam.y);
        showSpotCount += fillDown(map, camMap, curCam.x, curCam.y);
        search(map, camMap, index + 1, blindSpotCount - showSpotCount, cameras);
        eraseLeft(map, camMap, curCam.x, curCam.y);
        eraseUp(map, camMap, curCam.x, curCam.y);
        eraseRight(map, camMap, curCam.x, curCam.y);
        eraseDown(map, camMap, curCam.x, curCam.y);
    }

    private static int fillUp(int[][] map, boolean[][] camMap, int x, int y) {
        int showSpotCount = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == WALL) {
                break;
            }
            if (map[i][y] < SPACE) { // 이미 다른 감시카메라로 감시되고 있는 지대의 경우
                map[i][y]--;
                continue; // 보여진 지대의 수를 세지 않음
            }
            // 아래는 맵이 다른 카메라로 감시당하지도 않은 빈공간일 경우메만 해당됨
            map[i][y]--;
            if (!camMap[i][y]) {
                showSpotCount++;
            }

        }

        return showSpotCount;
    }

    private static int fillDown(int[][] map, boolean[][] camMap, int x, int y) {
        int showSpotCount = 0;
        for (int i = x + 1; i < map.length; i++) {
            if (map[i][y] == WALL) {
                break;
            }
            if (map[i][y] < SPACE) { // 이미 다른 감시카메라로 감시되고 있는 지대의 경우
                map[i][y]--;
                continue; // 보여진 지대의 수를 세지 않음
            }
            // 아래는 맵이 다른 카메라로 감시당하지도 않은 빈공간일 경우메만 해당됨
            map[i][y]--;
            if (!camMap[i][y]) {
                showSpotCount++;
            }

        }

        return showSpotCount;
    }

    private static int fillLeft(int[][] map, boolean[][] camMap, int x, int y) {
        int showSpotCount = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == WALL) {
                break;
            }
            if (map[x][i] < SPACE) { // 이미 다른 감시카메라로 감시되고 있는 지대의 경우
                map[x][i]--;
                continue; // 보여진 지대의 수를 세지 않음
            }
            // 아래는 맵이 다른 카메라로 감시당하지도 않은 빈공간일 경우메만 해당됨
            map[x][i]--;
            if (!camMap[x][i]) {
                showSpotCount++;
            }

        }

        return showSpotCount;
    }

    private static int fillRight(int[][] map, boolean[][] camMap, int x, int y) {
        int showSpotCount = 0;
        for (int i = y + 1; i < map[0].length; i++) {
            if (map[x][i] == WALL) {
                break;
            }
            if (map[x][i] < SPACE) { // 이미 다른 감시카메라로 감시되고 있는 지대의 경우
                map[x][i]--;
                continue; // 보여진 지대의 수를 세지 않음
            }
            // 아래는 다른 카메라로 감시당하지 않은 빈공간일 경우메만 해당됨
            map[x][i]--;
            if (!camMap[x][i]) {
                showSpotCount++;
            }

        }

        return showSpotCount;
    }

    private static int eraseUp(int[][] map, boolean[][] camMap, int x, int y) {
        int erasedSpotCount = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] != WALL) {
                map[i][y]++;
                if (map[i][y] == 0
                        && !camMap[i][y]) { // 중첩된 시야의 경우 마지막에 시야를 없앤 딱 한 번만 erasedSpot으로 셈, 또한 감시카메라는 셈에 포함하지 말아야함
                    erasedSpotCount++;
                }
                continue;
            }
            break; // 벽이면 break
        }
        return erasedSpotCount;
    }

    private static int eraseDown(int[][] map, boolean[][] camMap, int x, int y) {
        int erasedSpotCount = 0;
        for (int i = x + 1; i < map.length; i++) {
            if (map[i][y] != WALL) {
                map[i][y]++;
                if (map[i][y] == 0 && !camMap[i][y]) {
                    erasedSpotCount++;
                }
                continue;
            }
            break;
        }
        return erasedSpotCount;
    }

    private static int eraseLeft(int[][] map, boolean[][] camMap, int x, int y) {
        int erasedSpotCount = 0;
        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] != WALL) {
                map[x][i]++;
                if (map[x][i] == 0 && !camMap[x][i]) {
                    erasedSpotCount++;
                }
                continue;
            }
            break;
        }
        return erasedSpotCount;
    }

    private static int eraseRight(int[][] map, boolean[][] camMap, int x, int y) {
        int erasedSpotCount = 0;
        for (int i = y + 1; i < map[0].length; i++) {
            if (map[x][i] != WALL) {
                map[x][i]++;
                if (map[x][i] == 0 && !camMap[x][i]) {
                    erasedSpotCount++;
                }
                continue;
            }
            break;
        }
        return erasedSpotCount;
    }
}
