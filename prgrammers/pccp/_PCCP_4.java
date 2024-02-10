package prgrammers.pccp;

/*
    프로그래머스 PCCP 기출문제 4번: 수레 움직이기
*/
class _PCCP_4 {
    public static void main(String[] args) {
        _PCCP_4 solved = new _PCCP_4();
        int[][] maze = {
                {1, 0, 2},
                {0, 0, 0},
                {5, 0, 5},
                {4, 0, 3}
        };
        System.out.println(solved.solution(maze)); // answer: 7
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int N, M;
    private boolean isRedEnd = false;
    private boolean isBlueEnd = false;
    private boolean[][] redVisited;
    private boolean[][] blueVisited;
    private int[][] map;

    public int solution(int[][] maze) {
        N = maze.length;
        M = maze[0].length;
        redVisited = new boolean[N][M];
        blueVisited = new boolean[N][M];
        map = new int[N][M];
        Node red = null;
        Node blue = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maze[i][j];
                if (maze[i][j] == 1) {
                    redVisited[i][j] = true;
                    red = new Node(i, j);
                    continue;
                }
                if (maze[i][j] == 2) {
                    blueVisited[i][j] = true;
                    blue = new Node(i, j);
                }
            }
        }
        int answer = takeATurn(red, blue, 0);
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }


    private Node getNextNode(Node cur, int direction) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nx = cur.x + dx[direction];
        int ny = cur.y + dy[direction];
        return new Node(nx, ny);
    }

    private boolean isPossible(Node red, Node nextRed, Node blue, Node nextBlue) {
        if (
                nextRed.x < 0 || nextRed.y < 0 || nextRed.x >= N || nextRed.y >= M ||
                        nextBlue.x < 0 || nextBlue.y < 0 || nextBlue.x >= N || nextBlue.y >= M ||
                        map[nextRed.x][nextRed.y] == 5 || map[nextBlue.x][nextBlue.y] == 5
        ) {
            return false;
        }

        // both wagon cant switch each other
        if (
                (red.x == nextBlue.x && red.y == nextBlue.y) &&
                        (blue.x == nextRed.x && blue.y == nextRed.y)
        ) {
            return false;
        }

        // already visited
        if (
                (!isRedEnd && redVisited[nextRed.x][nextRed.y]) ||
                        (!isBlueEnd && blueVisited[nextBlue.x][nextBlue.y])
        ) {
            return false;
        }

        // both wagon crashed
        if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
            return false;
        }

        return true;
    }

    private int takeATurn(Node red, Node blue, int depth) {
        if (isRedEnd && isBlueEnd) {
            return depth;
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Node nextRed = (!isRedEnd) ? getNextNode(red, i) : red;
                Node nextBlue = (!isBlueEnd) ? getNextNode(blue, j) : blue;

                if (!isPossible(red, nextRed, blue, nextBlue)) {
                    continue;
                }
                redVisited[nextRed.x][nextRed.y] = true;
                blueVisited[nextBlue.x][nextBlue.y] = true;

                if (map[nextRed.x][nextRed.y] == 3) {
                    isRedEnd = true;
                }
                if (map[nextBlue.x][nextBlue.y] == 4) {
                    isBlueEnd = true;
                }

                answer = Math.min(answer, takeATurn(nextRed, nextBlue, depth + 1));

                isRedEnd = false;
                isBlueEnd = false;
                redVisited[nextRed.x][nextRed.y] = false;
                blueVisited[nextBlue.x][nextBlue.y] = false;
            }
        }
        return answer;
    }
}
