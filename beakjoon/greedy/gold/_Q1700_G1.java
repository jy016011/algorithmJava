package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class _Q1700_G1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        Set<Integer> multitap = new HashSet<>();
        int K = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> sequence = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            sequence.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int count = 0;

        while (!sequence.isEmpty() && multitap.size() <= n) {
            boolean isChanged = false;
            int plug = sequence.remove(0);
            if (multitap.contains(plug)) {
                continue;
            }
            if (multitap.size() < n) {
                multitap.add(plug);
                continue;
            }
            int maxIndex = 0;
            for (int pluged : multitap) {
                if (!sequence.contains(pluged)) {
                    multitap.remove(pluged);
                    multitap.add(plug);
                    count++;
                    isChanged = true;
                    break;
                }
                for (int i = 0; i < sequence.size(); i++) {
                    if (pluged == sequence.get(i)) {
                        maxIndex = Math.max(maxIndex, i);
                        break;
                    }
                }
            }

            if (!isChanged) {
                multitap.remove(sequence.get(maxIndex));
                multitap.add(plug);
                count++;
            }

        }
        System.out.println(count);
    }
}
