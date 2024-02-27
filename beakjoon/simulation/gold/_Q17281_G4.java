package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q17281_G4 {
    public static class BaseBall {
        public int[] battingOrder;
        public int[][] players;
        public int maxScore, outCount, currentBatter, inningLimit;
        private boolean[] bases;

        public BaseBall(int N) {
            inningLimit = N;
            players = new int[inningLimit][10];
            battingOrder = new int[10];
            currentBatter = 1;
        }

        public void setBattingOrder(int depth, boolean[] visited) {
            if (depth == 10) {
                int score = 0;
                for (int i = 0; i < inningLimit; i++) {
                    bases = new boolean[4];
                    score += runInning(i);
                }
                maxScore = Math.max(maxScore, score);
                currentBatter = 1;
                return;
            }
            if (depth == 4) {
                setBattingOrder(depth + 1, visited);
                return;
            }
            for (int i = 2; i < 10; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    battingOrder[depth] = i;
                    setBattingOrder(depth + 1, visited);
                    visited[i] = false;
                }
            }
        }

        public int runInning(int N) {
            int score = 0;
            while (outCount < 3) {
                score += hitBall(players[N][battingOrder[currentBatter]]);
                currentBatter++;
                if (currentBatter == 10) {
                    currentBatter = 1;
                }
            }
            outCount = 0;
            return score;
        }

        private int hitBall(int hit) {
            int score = 0;
            if (hit == 0) {
                outCount++;
                return 0;
            }
            score += runnerMove(hit);
            score += batterMove(hit);
            return score;
        }

        private int runnerMove(int hit) {
            int score = 0;
            for (int i = 3; i >= 1; i--) {
                if (bases[i] && (i + hit) > 3) {
                    score++;
                    bases[i] = false;
                    continue;
                }
                if (bases[i]) {
                    bases[i] = false;
                    bases[i + hit] = true;
                }
            }
            return score;
        }

        private int batterMove(int hit) {
            if (hit > 3) {
                return 1;
            }
            bases[hit] = true;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        BaseBall baseBall = new BaseBall(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j < 10; j++) {
                baseBall.players[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        boolean[] visited = new boolean[10];
        baseBall.battingOrder[4] = 1;
        baseBall.setBattingOrder(1, visited);
        System.out.println(baseBall.maxScore);
    }
}
