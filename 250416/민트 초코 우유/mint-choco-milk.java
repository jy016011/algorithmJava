
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int Left = 2;
    private static final int Right = 3;

    private static int N;

    static class Student {
        int x, y;
        char taste;
        int piety;

        Student(int x, int y, char taste, int piety) {
            this.x = x;
            this.y = y;
            this.taste = taste;
            this.piety = piety;
        }
    }

    static char[][] tasteMap;
    static int[][] pietyMap;
    static int[][] teamMap;
    static boolean[][] spreaderMap;
    static Map<Character, Integer> tasteOrder;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());
        tasteMap = new char[N][N];
        pietyMap = new int[N][N];
        // 맛 별 우선순위 부여
        tasteOrder = new HashMap<>();
        tasteOrder.put('T', 1);
        tasteOrder.put('C', 1);
        tasteOrder.put('M', 1);

        tasteOrder.put('H', 2); // cHoco milk
        tasteOrder.put('I', 2); // mInt milk
        tasteOrder.put('N', 2); // miNt choco

        tasteOrder.put('K', 3); // mint chock milK

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                tasteMap[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                pietyMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int turn = 0; turn < T; turn++) {
            // 아침시간
            morning();
            // 점심시간
            PriorityQueue<Student> spreaders = pickSpreaders();

            // 저녁시간
            spread(spreaders);

//            // 신앙심 출력
            printPiety();
        }
    }

    private static void morning() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                pietyMap[i][j]++;
            }
        }
    }

    private static PriorityQueue<Student> pickSpreaders() {
        // 대표자들을 저장할 우선순위큐, 큐 내부의 순서대로 전파를 함
        PriorityQueue<Student> spreaders = new PriorityQueue<>(((o1, o2) -> {
            if (tasteOrder.get(o1.taste) == tasteOrder.get(o2.taste) && o1.piety == o2.piety && o1.x == o2.y) {
                return o1.y - o2.y; // 4. 열 오름차순
            } else if (tasteOrder.get(o1.taste) == tasteOrder.get(o2.taste) && o1.piety == o2.piety) {
                return o1.x - o2.x; // 2. 행 오름차순
            } else if (tasteOrder.get(o1.taste) == tasteOrder.get(o2.taste)) {
                return o2.piety - o1.piety; // 1. 신앙심 내림차순
            }
            return tasteOrder.get(o1.taste) - tasteOrder.get(o2.taste); // 0. 맛 그룹 순서
        }));
        boolean[][] visited = new boolean[N][N];
        spreaderMap = new boolean[N][N];
        for (int startX = 0; startX < N; startX++) {
            for (int startY = 0; startY < N; startY++) {
                if (visited[startX][startY]) {
                    continue;
                }
                spreaders.offer(pickSpreader(startX, startY, visited, spreaders));
            }
        }

        return spreaders;
    }

    private static void spread(PriorityQueue<Student> spreaders) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!spreaders.isEmpty()) {
            Student curSpreader = spreaders.poll();
            if (!spreaderMap[curSpreader.x][curSpreader.y]) {
                continue;
            }
            int piety = curSpreader.piety - 1;
            pietyMap[curSpreader.x][curSpreader.y] = 1;
            int direction = curSpreader.piety % 4;
            int x = curSpreader.x;
            int y = curSpreader.y;

            while (piety > 0) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    break;
                }
                // 전파 대상이 전파자와 신봉 음식이 같은 경우
                if (curSpreader.taste == tasteMap[nx][ny]) {
                    x = nx;
                    y = ny;
                } else { // 전파 대상이 전파자의 신봉 음식과 다른 경우
                    if (piety > pietyMap[nx][ny]) { // 전파자의 신앙심이 더 큰 경우
                        tasteMap[nx][ny] = curSpreader.taste;
                        pietyMap[nx][ny]++;
                        piety -= pietyMap[nx][ny];
                        spreaderMap[nx][ny] = false;
                        x = nx;
                        y = ny;
                    } else { // 전파자의 신앙심이 이하인 경우
                        // 약한 전파
                        // 맛이 바뀜
                        combineTaste(curSpreader.taste, nx, ny);
                        pietyMap[nx][ny] += piety;
                        piety = 0;
                        spreaderMap[nx][ny] = false;
                    }
                }
            }
        }
    }

    private static void printPiety() {
        char[] sequence = {'K', 'N', 'I', 'H', 'M', 'C', 'T'};
        StringBuilder sb = new StringBuilder();
        for (char taste :
                sequence) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tasteMap[i][j] != taste) {
                        continue;
                    }
                    total += pietyMap[i][j];
                }

            }
            sb.append(total).append(' ');
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void combineTaste(char spreaderTaste, int x, int y) {
        char targetTaste = tasteMap[x][y];
        if (spreaderTaste == 'T') { // 전파자가 민트인 경우
            if (targetTaste == 'C') { // 민트 + 초코 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'M') { // 민트 + 우유 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'H') { // 민트 + 초코우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'I') { // 민트 + 민트우유 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'N') { // 민트 + 민트초코 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'K') { // 민트 + 민트초코우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'C') { // 전파자가 초코인 경우
            if (targetTaste == 'T') { // 민트 + 초코 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'M') { // 초코 + 우유 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'H') { // 초코 + 초코우유 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'I') { // 초코 + 민트우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'N') { // 초코 + 민트초코 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'K') { // 초코 + 민트초코우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'M') { // 전파자가 우유인 경우
            if (targetTaste == 'T') { // 우유 + 민트 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'C') { // 초코 + 우유 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'H') { // 우유 + 초코우유 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'I') { // 우유 + 민트우유 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'N') { // 우유 + 민트초코 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'K') { // 우유 + 민트초코우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'H') { // 전파자가 초코우유인 경우
            if (targetTaste == 'T') { // 초코우유 + 민트 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'C') { // 초코우유 + 초코 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'M') { // 초코우유 + 우유 = 초코우유
                tasteMap[x][y] = 'H';
                return;
            }
            if (targetTaste == 'I' || targetTaste == 'N' || targetTaste == 'K') { // 초코우유 + 민트우유(민트초코, 민트초코우유) = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'I') { // 전파자가 민트우유인 경우
            if (targetTaste == 'T') { // 민트우유 + 민트 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'C') { // 민트우유 + 초코 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'M') { // 민트우유 + 우유 = 민트우유
                tasteMap[x][y] = 'I';
                return;
            }
            if (targetTaste == 'H' || targetTaste == 'N' || targetTaste == 'K') { // 민트우유 + 초코우유(민트초코, 민트초코우유) = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'N') { // 전파자가 민트초코인 경우
            if (targetTaste == 'T') { // 민트초코 + 민트 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'C') { // 민트초코 + 초코 = 민트초코
                tasteMap[x][y] = 'N';
                return;
            }
            if (targetTaste == 'M') { // 민트초코 + 우유 = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
            if (targetTaste == 'H' || targetTaste == 'I' || targetTaste == 'K') { // 민트초코 + 초코우유(민트우유, 민트초코우유) = 민트초코우유
                tasteMap[x][y] = 'K';
                return;
            }
        }

        if (spreaderTaste == 'K') { // 전파자가 민트초코우유인 경우
            tasteMap[x][y] = 'K';
            return;
        }

    }

    private static Student pickSpreader(int startX, int startY, boolean[][] visited, PriorityQueue<Student> spreaders) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 각 팀의 학생들을 정렬할 우선순위 큐, 가장 첫번째 학생이 전파자(대표자)가 됨
        PriorityQueue<Student> team = new PriorityQueue<>(((o1, o2) -> {
            if (o1.piety == o2.piety && o1.x == o2.x) {
                return o1.y - o2.y; // 3.  열 오름차순
            } else if (o1.piety == o2.piety) {
                return o1.x - o2.x; // 2. 행 오름차순
            }
            return o2.piety - o1.piety; // 1. 신앙심 내림차순
        }));

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        char teamTaste = tasteMap[startX][startY];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            pietyMap[x][y]--; // 팀 구성원 모두의 신앙심 -1
            team.offer(new Student(x, y, tasteMap[x][y], pietyMap[x][y])); // 팀에 구성원 추가
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 다음 좌표가 맵 바깥이거나, 이미 방문했거나, 다른 맛일 경우 방문 안함
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || teamTaste != tasteMap[nx][ny]) {
                    continue;
                }

                // 같은 맛일 경우에만 방문
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});

            }

        }

        int teamSize = team.size();
        Student spreader = team.poll(); // 대표자
        spreader.piety += teamSize; // 대표자에게 구성원 수 만큼 더해줌(이미 반복문에서 1만큼 뺐으므로)
        pietyMap[spreader.x][spreader.y] = spreader.piety;
        spreaderMap[spreader.x][spreader.y] = true;

        return spreader;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr :
                matrix) {
            System.out.println(Arrays.toString(arr));
            ;
        }
        System.out.println("==============");

    }

    private static void printTasteMap() {
        for (char[] arr :
                tasteMap) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("dddddd");
    }
}
