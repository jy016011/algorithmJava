package beakjoon.implementation.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q2745_Notation1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String numberStr = st.nextToken();
        int notation = Integer.parseInt(st.nextToken());
        int decimal = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            if ((int)numberStr.charAt(i) >= 65){
                decimal += ((int)numberStr.charAt(i) - 55) * (int)Math.pow(notation,numberStr.length() - i - 1);
            }
            else
                decimal += ((int)numberStr.charAt(i) - 48) * (int)Math.pow(notation,numberStr.length() - i - 1);
        }
        System.out.println(decimal);
    }
}
