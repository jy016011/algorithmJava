package beakjoon.generalMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChangeNotation2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Character> arr = new ArrayList<>();
        int number = Integer.parseInt(st.nextToken());
        int notation = Integer.parseInt(st.nextToken());
        int digit ;
        while (number > 0){
            digit = number % notation;
            if(digit >= 10){
                digit += 55;
                arr.add((char) digit);
            }
            else {
                digit += 48;
                arr.add((char) digit);
            }
            number /= notation;
        }
        for(int i = arr.size() - 1; i >= 0; i-- ){
            System.out.print(arr.get(i));
        }
    }
}
