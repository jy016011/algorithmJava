package testDome;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        int[] dx = {-2, 2, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = fromRow + dx[i];
            int ny = fromColumn + dy[i];
            if (nx < 0 || ny < 0 || nx >= gameMatrix.length || ny >= gameMatrix[0].length) {
                continue;
            }
            if (i < 2) {
                if (nx - (dx[i] / 2) < 0 || nx - (dx[i] / 2) >= gameMatrix.length) {
                    continue;
                }
                if (!gameMatrix[nx - (dx[i] / 2)][ny]) {
                    continue;
                }
            }
            if (gameMatrix[nx][ny] && nx == toRow && ny == toColumn) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
                {false, false, true, true, false},
                {false, false, true, false, false},
                {false, false, true, true, false},
                {false, true, false, true, false},
                {false, false, true, false, false}
        };

        System.out.println(canTravelTo(gameMatrix, 2, 2, 0, 2));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 2, 1));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 2, 3));
        System.out.println(canTravelTo(gameMatrix, 2, 2, 4, 2));
    }
}
