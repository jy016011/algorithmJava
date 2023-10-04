package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1085_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());
        int distance;
        if ((x >= 0 && x <= w) || (y >= 0 && y <= h)){ // 각 변과의 수직 거리
            distance = Math.min(Math.abs(y),Math.abs(y - h));
            distance = Math.min(distance, Math.abs(x));
            distance = Math.min(distance, Math.abs(x - w));
        }
        else{ // 각 꼭지점과의 거리
            if (x < 0 && y > h){
                distance = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y - h, 2));
            } else if (x < 0 && y < 0) {
                distance = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            } else if (x > w && y > h) {
                distance = (int) Math.sqrt(Math.pow(x - w, 2) + Math.pow(y - h, 2));
            }
            else {
                distance = (int) Math.sqrt(Math.pow(x - w, 2) + Math.pow(y, 2));
            }
        }
        System.out.println(distance);
    }
}
