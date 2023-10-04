package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _Q11718_SystemOut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            String str = br.readLine();
            if (str == null || str.isEmpty())
                break;
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
