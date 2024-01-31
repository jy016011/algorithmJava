package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q9996_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String pattern = bufferedReader.readLine();
        int starIndex = pattern.indexOf('*');
        int overStarLength = pattern.length() - 1 - starIndex;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            boolean isCorrect = true;
            String filename = bufferedReader.readLine();
            if (filename.length() <= starIndex) { // for counterexample: aaa*a, aaa
                isCorrect = false;
            } else if (overStarLength > filename.substring(starIndex).length()) { // for counterexample: ab*bd, abd
                isCorrect = false;
            } else {
                for (int j = 0; j < starIndex; j++) { // 0 to * index
                    if (pattern.charAt(j) != filename.charAt(j)) {
                        isCorrect = false;
                        break;
                    }
                }
                for (int j = 1; j <= overStarLength; j++) { // last index to * + 1 index
                    if (pattern.charAt(pattern.length() - j) != filename.charAt(filename.length() - j)) {
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (isCorrect) {
                stringBuilder.append("DA").append(System.lineSeparator());
            } else {
                stringBuilder.append("NE").append(System.lineSeparator());
            }
        }
        System.out.println(stringBuilder);
    }
}
