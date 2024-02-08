package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// some simple tests while coding other works
public class tests {
    private static final int TEST = 1;
    private static int TEST2;
    static List<Integer> test1;
    private static int M;
    private static boolean[] visited = new boolean[50];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(bufferedReader.readLine());
        pickChicken(0);
    }

    private static void pickChicken(int depth) {
        if (depth == M) {
//            System.out.println(depth);
            return;
        }

        for (int i = depth; i < 50; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pickChicken(depth + 1);
                visited[i] = false;
            }
        }
    }


}
