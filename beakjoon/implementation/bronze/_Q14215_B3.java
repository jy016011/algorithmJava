package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q14215_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int max = Math.max(x, y);
        int z = Integer.parseInt(stringTokenizer.nextToken());
        max = Math.max(max, z);
        if (max == x){
            if (x >= y + z){
                x = y + z - 1;
            }
        } else if (max == y) {
            if (y >= x + z){
                y = x + z - 1;
            }
        }
        else {
            if (z >= x + y){
                z = x + y - 1;
            }
        }
        System.out.println(x + y + z);
    }
}
