package beakjoon.backTracking.dfsAndBfs.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q5014_S1 {
    private static final String CANNOT_USE_ELEVATOR = "use the stairs";
    private static int F, S, G;
    private static int[] floors;
    private static boolean isArrived = false;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        F = Integer.parseInt(stringTokenizer.nextToken()); // max floor of building
        floors = new int[F + 1];
        S = Integer.parseInt(stringTokenizer.nextToken()); // location of Gang Ho
        floors[S] = 1;
        G = Integer.parseInt(stringTokenizer.nextToken()); // location of StartLink
        int U = Integer.parseInt(stringTokenizer.nextToken()); // unit of moving up
        int D = Integer.parseInt(stringTokenizer.nextToken()); // unit of moving down
        bfs(U, D);
        if (!isArrived) {
            System.out.println(CANNOT_USE_ELEVATOR);
        } else {
            System.out.println(floors[G] - 1);
        }
    }

    private static void bfs(int upUnit, int downUnit) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        while (!queue.isEmpty()) {
            int curLocation = queue.poll();
            if (curLocation == G) {
                isArrived = true;
                return;
            }
            if (curLocation + upUnit <= F && floors[curLocation + upUnit] == 0) {
                floors[curLocation + upUnit] = floors[curLocation] + 1;
                queue.offer(curLocation + upUnit);
            }
            if (curLocation - downUnit > 0 && floors[curLocation - downUnit] == 0) {
                floors[curLocation - downUnit] = floors[curLocation] + 1;
                queue.offer(curLocation - downUnit);
            }
        }
    }
}
