package beakjoon.implementation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _Q1002_Turret {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] jo = new int[3];
        int[] beak = new int[3];
        int cnt;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                jo[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < 3; j++){
                beak[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(getMeetCount(jo,beak)).append("\n");
        }
        System.out.println(sb);
    }
    public static int getMeetCount(int[] c1, int[] c2){
        int distancePow = (int)(Math.pow(c1[0] - c2[0], 2) + Math.pow(c1[1] - c2[1], 2));

        if(c1[0] == c2[0] && c1[1] == c2[1]){
            if (c1[2] == c2[2])
                return -1;
            else return 0;
        }
        if (distancePow > Math.pow((c1[2] + c2[2]),2))
            return 0;
        else if (distancePow == Math.pow((c1[2] + c2[2]),2)) {
            return 1;
        } else if (distancePow == Math.pow((c1[2] - c2[2]), 2)) {
            return 1;
        } else if (distancePow < Math.pow((c1[2] - c2[2]), 2)) {
            return 0;
        }

        return 2;
    }
}
