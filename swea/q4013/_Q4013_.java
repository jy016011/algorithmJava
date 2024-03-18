package swea.q4013;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q4013_ {
    private static class Magnet {
        int[] blades = new int[8];

        public Magnet(StringTokenizer stringTokenizer) {
            for (int i = 0; i < 8; i++) {
                blades[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        public void rotate(int direction) {
            if (direction == 1) {
                rotateNatural();
                return;
            }
            if (direction == -1) {
                rotateReverse();
            }
        }

        private void rotateNatural() {
            int temp = blades[7];
            for (int i = 6; i >= 0; i--) {
                blades[i + 1] = blades[i];
            }
            blades[0] = temp;
        }

        private void rotateReverse() {
            int temp = blades[0];
            for (int i = 1; i < 8; i++) {
                blades[i - 1] = blades[i];
            }
            blades[7] = temp;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("codingtest/src/swea/q4013/sample_input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder results = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = Integer.parseInt(bufferedReader.readLine());
            Magnet[] magnets = new Magnet[4];
            for (int i = 0; i < 4; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                magnets[i] = new Magnet(stringTokenizer);
            }
            for (int i = 0; i < K; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int magnetNumber = Integer.parseInt(stringTokenizer.nextToken());
                int direction = Integer.parseInt(stringTokenizer.nextToken());
                if (magnetNumber == 1) {
                    rotateFirst(magnets, direction);
                    continue;
                }
                if (magnetNumber == 2) {
                    rotateSecond(magnets, direction);
                    continue;
                }
                if (magnetNumber == 3) {
                    rotateThird(magnets, direction);
                    continue;
                }
                if (magnetNumber == 4) {
                    rotateFourth(magnets, direction);
                }
            }
            int score = 0;
            for (int i = 0; i < 4; i++) {
                if (magnets[i].blades[0] == 1) {
                    score += (int) Math.pow(2, i);
                }
            }
            results.append(String.format("#%d %d", test_case, score)).append(System.lineSeparator());
        }
        System.out.println(results);
    }

    private static void rotateFirst(Magnet[] magnets, int direction) {
        int reverseDirection = direction * -1;
        Magnet first = magnets[0];
        Magnet second = magnets[1];
        Magnet third = magnets[2];
        Magnet fourth = magnets[3];

        // for fourth
        if (
                first.blades[2] != second.blades[6] &&
                        second.blades[2] != third.blades[6] &&
                        third.blades[2] != fourth.blades[6]
        ) {
            fourth.rotate(reverseDirection);
        }

        // for third
        if (first.blades[2] != second.blades[6] && second.blades[2] != third.blades[6]) {
            third.rotate(direction);
        }

        // for second
        if (first.blades[2] != second.blades[6]) {
            second.rotate(reverseDirection);
        }
        first.rotate(direction);
    }

    private static void rotateSecond(Magnet[] magnets, int direction) {
        int reverseDirection = direction * -1;
        Magnet first = magnets[0];
        Magnet second = magnets[1];
        Magnet third = magnets[2];
        Magnet fourth = magnets[3];

        // for fourth
        if (second.blades[2] != third.blades[6] && third.blades[2] != fourth.blades[6]) {
            fourth.rotate(direction);
        }

        // for third
        if (second.blades[2] != third.blades[6]) {
            third.rotate(reverseDirection);
        }

        // for first
        if (second.blades[6] != first.blades[2]) {
            first.rotate(reverseDirection);
        }
        second.rotate(direction);
    }

    private static void rotateThird(Magnet[] magnets, int direction) {
        int reverseDirection = direction * -1;
        Magnet first = magnets[0];
        Magnet second = magnets[1];
        Magnet third = magnets[2];
        Magnet fourth = magnets[3];

        // for first
        if (third.blades[6] != second.blades[2] && second.blades[6] != first.blades[2]) {
            first.rotate(direction);
        }

        // for second
        if (third.blades[6] != second.blades[2]) {
            second.rotate(reverseDirection);
        }

        // for fourth
        if (fourth.blades[6] != third.blades[2]) {
            fourth.rotate(reverseDirection);
        }
        third.rotate(direction);
    }

    private static void rotateFourth(Magnet[] magnets, int direction) {
        int reverseDirection = direction * -1;
        Magnet first = magnets[0];
        Magnet second = magnets[1];
        Magnet third = magnets[2];
        Magnet fourth = magnets[3];

        // for first
        if (
                first.blades[2] != second.blades[6] &&
                        second.blades[2] != third.blades[6] &&
                        third.blades[2] != fourth.blades[6]
        ) {
            first.rotate(reverseDirection);
        }

        // for second
        if (fourth.blades[6] != third.blades[2] && third.blades[6] != second.blades[2]) {
            second.rotate(direction);
        }

        // for third
        if (third.blades[2] != fourth.blades[6]) {
            third.rotate(reverseDirection);
        }
        fourth.rotate(direction);
    }
}
