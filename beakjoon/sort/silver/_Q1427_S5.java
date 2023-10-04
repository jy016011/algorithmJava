package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _Q1427_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String N = bufferedReader.readLine();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N.length(); i++) {
            numbers.add((int) N.charAt(i) - '0');
        }
        numbers.sort(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            stringBuilder.append(numbers.get(i));
        }
        System.out.println(stringBuilder);
    }
}
