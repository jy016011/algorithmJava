package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// some simple tests while coding other works
public class tests {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        pickChickens(0, 1, 3, length, list);
    }

    private static void pickChickens(int depth, int start, int M, int length, List<Integer> list) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int num :
                    list) {
                sb.append(num).append(", ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i <= length; i++) {
            list.add(i);
            pickChickens(depth + 1, i + 1, M, length, list);
            list.remove(list.size() - 1);
        }
    }

}
