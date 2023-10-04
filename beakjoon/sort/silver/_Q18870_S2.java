package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _Q18870_S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<int[]> numbers = new ArrayList<>();
        int[] counts = new int[N];
        int[] answer = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++){
            int[] num = {Integer.parseInt(stringTokenizer.nextToken()) , i};
            numbers.add(num);
        }
        numbers.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0){
                counts[i] = 0;
            }
            else {
                if (numbers.get(i)[0] == numbers.get(i - 1)[0]){
                    counts[i] = counts[i - 1];
                }
                else {
                    counts[i] = counts[i - 1] + 1;
                }
            }
        }
        for (int i = 0; i < numbers.size(); i++) {
            answer[numbers.get(i)[1]] = counts[i];
        }
        for (int j : answer) {
            stringBuilder.append(j).append(" ");
        }
        System.out.println(stringBuilder);
    }
}
