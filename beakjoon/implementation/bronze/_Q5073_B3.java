package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q5073_B3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int max = Math.max(x, y);
            int z = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, z);
            if (x == 0 && y == 0 && z == 0)
                break;
            if (max == x){
                if (max >= y + z){
                    stringBuilder.append("Invalid\n");
                }
                else {
                    if (x == y && x == z)
                        stringBuilder.append("Equilateral\n");
                    else if (x == y || y == z || x == z)
                        stringBuilder.append("Isosceles\n");
                    else
                        stringBuilder.append("Scalene\n");
                }
            } else if (max == y) {
                if (max >= x + z){
                    stringBuilder.append("Invalid\n");
                }
                else {
                    if (y == z || x == z)
                        stringBuilder.append("Isosceles\n");
                    else
                        stringBuilder.append("Scalene\n");
                }
            }
            else {
                if (max >= y + x){
                    stringBuilder.append("Invalid\n");
                }
                else {
                    if (x == y)
                        stringBuilder.append("Isosceles\n");
                    else
                        stringBuilder.append("Scalene\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
