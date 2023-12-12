package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q8980_G1 {
    private static int C;
    private static int[] loadedBoxes;

    static class DeliveryInfo implements Comparable<DeliveryInfo> {
        int from, to, capacity;

        public DeliveryInfo(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
        }

        @Override
        public int compareTo(DeliveryInfo other) {
            if (this.to == other.to) {
                return other.from - this.from;
            }
            return this.to - other.to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(bufferedReader.readLine());
        DeliveryInfo[] infos = new DeliveryInfo[M];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int capacity = Integer.parseInt(stringTokenizer.nextToken());
            infos[i] = new DeliveryInfo(from, to, capacity);
        }
        Arrays.sort(infos);

        loadedBoxes = new int[N + 1];
        int result = 0;
        for (DeliveryInfo info : infos) {
            int loadedCapacity = 0;
            int remainCapacity = getRemainCapacity(info.from, info.to);
            for (int i = info.from; i < info.to; i++) {
                if (remainCapacity > 0) {
                    loadedCapacity = Math.min(remainCapacity, info.capacity);
                    loadedBoxes[i] += loadedCapacity;
                }
            }
            result += loadedCapacity;
        }

        System.out.println(result);
    }

    private static int getRemainCapacity(int from, int to) {
        int remainCapacity = C;
        for (int i = from; i < to; i++) {
            remainCapacity = Math.min(remainCapacity, C - loadedBoxes[i]);
        }
        return remainCapacity;
    }

}
