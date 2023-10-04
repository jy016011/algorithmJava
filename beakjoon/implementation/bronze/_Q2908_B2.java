package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2908_B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < 2 ; i++) {
            String number = st.nextToken();
            for (int j = number.length() - 1; j >= 0; j--) {
                sb.append(number.charAt(j));
            }
            max = Math.max(Integer.parseInt(sb.toString()), max);
            sb.setLength(0);
        }
        System.out.println(max);
    }
}
