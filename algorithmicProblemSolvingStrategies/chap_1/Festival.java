package algorithmicProblemSolvingStrategies.chap_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Festival {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for (int testCase = 0; testCase < C; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int[] costs = new int[N];
            int L = Integer.parseInt(stringTokenizer.nextToken());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < N; i++) {
                costs[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            double minAvgCost = Integer.MAX_VALUE;
            for (int length = L; length <= N; length++) {
                for (int startDay = 0; startDay <= N - length; startDay++) {
                    int sum = 0;
                    for (int i = startDay; i < startDay + length; i++) {
                        sum += costs[i];
                    }
                    double avg = (double) sum / length;
                    minAvgCost = Math.min(minAvgCost, avg);
                }
            }
            result.append(minAvgCost).append(System.lineSeparator());
        }
        System.out.println(result);
    }
}
