package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q3009_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] xIndex = new int[3];
        int[] yIndex = new int[3];
        int xResult;
        int yResult;
        for (int i = 0; i < 3; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            xIndex[i] = Integer.parseInt(stringTokenizer.nextToken());
            yIndex[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        if (xIndex[1] == xIndex[0]){
            xResult = xIndex[2];
        } else if (xIndex[1] == xIndex[2]) {
            xResult = xIndex[0];
        }
        else xResult = xIndex[1];

        if (yIndex[1] == yIndex[0]){
            yResult = yIndex[2];
        } else if (yIndex[1] == yIndex[2]) {
            yResult = yIndex[0];
        }
        else yResult = yIndex[1];
        System.out.println(xResult + " " + yResult);
    }
}
