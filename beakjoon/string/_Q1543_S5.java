package beakjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _Q1543_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String document = bufferedReader.readLine();
        String target = bufferedReader.readLine();
        int index = 0;
        int count = 0;
        while (true) {
            index = document.indexOf(target, index);
            if (index == -1) {
                break;
            }
            index += target.length();
            count++;
        }
        System.out.println(count);
    }
}
