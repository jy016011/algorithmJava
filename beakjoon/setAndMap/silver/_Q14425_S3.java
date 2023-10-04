package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _Q14425_S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;
        HashSet<String> setS = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setS.add(bufferedReader.readLine());
        }
        for (int i = 0; i < M; i++) {
            String target = bufferedReader.readLine();
            if (setS.contains(target))
                count += 1;
        }
        System.out.println(count);

    }
}
