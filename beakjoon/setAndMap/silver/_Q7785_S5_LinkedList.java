package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _Q7785_S5_LinkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String> members = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            String state = stringTokenizer.nextToken();
            if (state.equals("enter"))
                members.add(name);
            else
                members.remove(name);
        }
        members.sort(Comparator.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String name:
                members) {
            stringBuilder.append(name).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
