package beakjoon.hash.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _Q17219_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, String> passwords = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String url = stringTokenizer.nextToken();
            String password = stringTokenizer.nextToken();
            passwords.put(url, password);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringBuilder.append(passwords.get(bufferedReader.readLine()))
                    .append(System.lineSeparator());

        }
        System.out.println(stringBuilder);
    }
}
