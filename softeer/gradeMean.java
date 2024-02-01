package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gradeMean {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N + 1];
        int[] sumArr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
            sumArr[i] += (S[i] + sumArr[i - 1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            int sum = sumArr[last] - sumArr[first - 1];
            sb.append(String.format("%.2f", (double) sum / (last - first + 1))).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
