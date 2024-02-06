package afterTests;

import java.util.ArrayList;
import java.util.List;

public class MinCut {
    static boolean[] visited;

    public static void main(String[] args) {
        int[] origin = {1, 4, 3, 2};
        int[] desired = {1, 2, 4, 3};
        System.out.println(getMin(origin, desired)); // 3

        origin = new int[]{1, 2, 4, 3, 5};
        desired = new int[]{2, 4, 3, 5, 1};
        System.out.println(getMin(origin, desired)); // 2

        origin = new int[]{1, 4, 3, 2, 5};
        desired = new int[]{2, 4, 3, 5, 1};
        System.out.println(getMin(origin, desired)); // 4

        origin = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        desired = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(getMin(origin, desired)); // 1

        origin = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        desired = new int[]{6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
        System.out.println(getMin(origin, desired)); // 2
    }

    private static int getMin(int[] origin, int[] desired) {
        visited = new boolean[origin.length + 1];
        int count = 0;
        for (int i = origin.length; i >= 1; i--) {
            List<int[]> originSubsets = getSubsets(origin, i);
            List<int[]> desiredSubsets = getSubsets(desired, i);
            count += countSameSet(originSubsets, desiredSubsets, i);
        }
        return count;
    }

    private static int countSameSet(List<int[]> origins, List<int[]> desireds, int size) {
        int count = 0;
        for (int[] originSub : origins) {
            for (int[] desiredSub : desireds) {
                boolean isSame = true;
                for (int i = 0; i < size; i++) {
                    if (originSub[i] != desiredSub[i]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int number : originSub) {
                        visited[number] = true;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private static List<int[]> getSubsets(int[] origin, int size) {
        List<int[]> subsets = new ArrayList<>();
        for (int i = 0; i <= origin.length - size; i++) {
            int[] subset = new int[size];
            boolean isFulled = true;
            for (int j = 0; j < size; j++) {
                if (!visited[origin[i + j]]) {
                    subset[j] = origin[i + j];
                    continue;
                }
                isFulled = false;
            }
            if (isFulled) {
                subsets.add(subset);
            }
        }
        return subsets;
    }
}
