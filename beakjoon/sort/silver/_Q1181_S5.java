package beakjoon.sort.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _Q1181_S5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        List<String> strList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++){
            strList.add(bufferedReader.readLine());
        }
        strList.sort((o1, o2) -> {
            if (o1.length() == o2.length())
                return o1.compareTo(o2);
            else
                return o1.length() - o2.length();
        });
        for (int i = 0; i < strList.size(); i++) {
            if (i != 0){
                if (!strList.get(i).equals(strList.get(i - 1))){
                    stringBuilder.append(strList.get(i)).append("\n");
                }
            }
            else
                stringBuilder.append(strList.get(i)).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
