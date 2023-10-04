package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _Q10814_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String[]> members = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] tmp = bufferedReader.readLine().split(" ");
            members.add(tmp);
        }
        members.sort(Comparator.comparingInt(o -> Integer.parseInt(o[0])));
        for (String[] member : members) {
            stringBuilder.append(member[0]).append(" ");
            stringBuilder.append(member[1]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
