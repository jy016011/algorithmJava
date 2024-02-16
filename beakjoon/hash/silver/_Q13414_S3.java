package beakjoon.hash.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _Q13414_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String studentNumber = bufferedReader.readLine();
            set.remove(studentNumber);
            set.add(studentNumber);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] students = set.toArray(new String[0]);
        for (String student : students) {
            if (K == 0) {
                break;
            }
            stringBuilder.append(student).append(System.lineSeparator());
            K--;
        }
        System.out.println(stringBuilder);
    }
}
