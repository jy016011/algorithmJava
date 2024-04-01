package prgrammers.kakaoRecruit;

class Solution {
    public static void main(String[] args) {
        Solution solved = new Solution();
        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1,}
        };
        int[][] lock = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int[][] key2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0,}
        };
        int[][] lock2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] key3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1,}
        };
        int[][] lock3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println(solved.solution(key, lock)); // true
        System.out.println(solved.solution(key2, lock2)); // false
        System.out.println(solved.solution(key3, lock3)); // false
    }

    public boolean solution(int[][] key, int[][] lock) {
        for (int i = 0; i < 4; i++) {
            int[][] rotated = rotate(0, i, key);
            if (search(rotated, lock)) {
                return true;
            }
        }
        return false;
    }

    private int[][] rotate(int depth, int targetTime, int[][] key) {
        if (depth == targetTime) {
            return key;
        }
        int[][] temp = new int[key.length][key[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                temp[i][j] = key[j][(key[0].length - 1) - i];
            }
        }
        return rotate(depth + 1, targetTime, temp);
    }

    private boolean search(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        for (int dr = 0; dr < (M + N - 1); dr++) {
            for (int dc = 0; dc < (M + N - 1); dc++) {
                if (isUnlock(key, lock, dr, dc)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isUnlock(int[][] key, int[][] lock, int dr, int dc) {
        int M = key.length;
        int N = lock.length;
        int[][] extendedLock = new int[(M - 1) * 2 + N][(M - 1) * 2 + N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(lock[i], 0, extendedLock[i + M - 1], M - 1, N);
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                extendedLock[r + dr][c + dc] += key[r][c];
            }
        }
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (extendedLock[r + M - 1][c + M - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
