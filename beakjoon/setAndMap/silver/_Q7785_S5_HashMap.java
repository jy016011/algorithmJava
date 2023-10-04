package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _Q7785_S5_HashMap {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, String> members = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String name = stringTokenizer.nextToken();
            String state = stringTokenizer.nextToken();
            members.put(name, state);
        }
        List<String> attendance = new ArrayList<>(members.keySet());
        attendance.sort(Comparator.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (String name:
             attendance) {
            if (members.get(name).equals("enter"))
                stringBuilder.append(name).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
