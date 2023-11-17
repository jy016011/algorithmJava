package q5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q5215_ {
    static boolean[] visited;
    static int[][] ingredient;
    static int cal;
    static int result, limit;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("codingtest/src/swea/q5215/input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            limit = Integer.parseInt(stringTokenizer.nextToken());
            cal = Integer.parseInt(stringTokenizer.nextToken());
            ingredient = new int[limit][2];
            visited = new boolean[limit];
            result = 0;
            for (int i = 0; i < limit; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                ingredient[i][0] = Integer.parseInt(stringTokenizer.nextToken());
                ingredient[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            }
            makeHamburger(0, 0, 0);
            System.out.println(String.format("#%d ", testCase) + result);
        }
    }

    public static void makeHamburger(int count, int score, int currentCal) {
        if (currentCal > cal || count > limit) {
            return;
        }
        if (count == limit) {
            result = Math.max(result, score);
            return;
        }
        makeHamburger(count + 1, score, currentCal);
        makeHamburger(count + 1, score + ingredient[count][0], currentCal + ingredient[count][1]);
    }
}
