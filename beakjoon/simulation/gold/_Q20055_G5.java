package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q20055_G5 {
    private static class ConveyorBelt {
        int[] belt;
        boolean[] isRobotOn;
        int upIndex;
        int downIndex;
        int countOfZero;

        public ConveyorBelt(int N) {
            belt = new int[2 * N + 1];
            isRobotOn = new boolean[2 * N + 1];
            upIndex = 1;
            downIndex = N;
        }

        public void rotate() {
            upIndex--;
            upIndex = correctIndex(upIndex);
            downIndex--;
            downIndex = correctIndex(downIndex);
            if (isRobotOn[downIndex]) {
                isRobotOn[downIndex] = false;
            }
        }

        public void robotMove() {
            int curIndex = downIndex - 1;
            curIndex = correctIndex(curIndex);
            while (curIndex != upIndex) {
                if (!isRobotOn[curIndex]) {
                    curIndex--;
                    curIndex = correctIndex(curIndex);
                    continue;
                }
                // move from 2N to 1 index
                if (curIndex == belt.length - 1) {
                    if (!isRobotOn[1] && belt[1] > 0) {
                        isRobotOn[1] = true;
                        belt[1]--;
                        if (belt[1] == 0) {
                            countOfZero++;
                        }
                        isRobotOn[curIndex] = false;
                    }
                    curIndex--;
                    curIndex = correctIndex(curIndex);
                    continue;
                }
                // move from other index
                if (!isRobotOn[curIndex + 1] && belt[curIndex + 1] > 0) {
                    isRobotOn[curIndex + 1] = true;
                    belt[curIndex + 1]--;
                    if (belt[curIndex + 1] == 0) {
                        countOfZero++;
                    }
                    isRobotOn[curIndex] = false;
                }
                curIndex--;
                curIndex = correctIndex(curIndex);
            }

            if (isRobotOn[downIndex]) {
                isRobotOn[downIndex] = false;
            }
        }

        public void loadRobot() {
            if (belt[upIndex] > 0) {
                isRobotOn[upIndex] = true;
                belt[upIndex]--;
                if (belt[upIndex] == 0) {
                    countOfZero++;
                }
            }
        }

        //correct '0' index to '2N' index for circular structure of belt
        private int correctIndex(int index) {
            if (index == 0) {
                return belt.length - 1;
            }
            return index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        ConveyorBelt conveyorBelt = new ConveyorBelt(N);
        int K = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= 2 * N; i++) {
            conveyorBelt.belt[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int stepCount = 0;
        while (conveyorBelt.countOfZero < K) {
            conveyorBelt.rotate();
            conveyorBelt.robotMove();
            conveyorBelt.loadRobot();
            stepCount++;
        }
        System.out.println(stepCount);
    }
}
