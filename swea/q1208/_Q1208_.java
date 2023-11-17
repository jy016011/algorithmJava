package swea.q1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _Q1208_ {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("codingtest/src/swea/q1208/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            int count = Integer.parseInt(bufferedReader.readLine());
            StringBuilder stringBuilder = new StringBuilder(String.format("#%d", testCase) + " ");
            ArrayList<Integer> boxes = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                boxes.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            while (count > 0) {
                boxes.sort(Comparator.naturalOrder());
                boxes.set(0, boxes.get(0) + 1);
                boxes.set(boxes.size() - 1, boxes.get(boxes.size() - 1) - 1);
                count--;
            }
            boxes.sort(Comparator.naturalOrder());
            stringBuilder.append(boxes.get(boxes.size() - 1) - boxes.get(0));
            System.out.println(stringBuilder);
        }
    }
}
