package swea.q5658;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("codingtest/src/swea/q5658/sample_input.txt"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder results = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            char[] lock = new char[N];
            int K = Integer.parseInt(stringTokenizer.nextToken());
            String sequence = bufferedReader.readLine();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < sequence.length(); i++) {
                lock[i] = sequence.charAt(i);
            }

            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(lock));
                int[] slices = slice(lock);
//                System.out.println(Arrays.toString(slices));
                storeInPriorityQueue(pq, slices);
                lock = rotate(lock);
            }
            int result = getTarget(K, pq);
            results.append(String.format("#%d %d", test_case, result)).append(System.lineSeparator());
        }
        System.out.println(results);
    }

    private static int getTarget(int targetIndex, PriorityQueue<Integer> pq) {
        if (targetIndex == 1 && !pq.isEmpty()) {
            return pq.peek();
        }
        int curIndex = 1;
        int before = pq.poll();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            if (before != cur) {
                curIndex++;
                before = cur;
            }
            if (targetIndex == curIndex) {
                return cur;
            }
        }
        return -1;
    }

    private static void storeInPriorityQueue(PriorityQueue<Integer> pq, int[] slices) {
        for (int slice : slices) {
            pq.offer(slice);
        }
    }

    private static int[] slice(char[] lock) {
        int sliceSize = lock.length / 4;
        int[] slices = new int[4];
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            StringBuilder slice = new StringBuilder();
            for (int j = 0; j < sliceSize; j++) {
                slice.append(lock[idx]);
                idx++;
            }
//            System.out.println(slice);
            int decimal = hex_to_dec(slice.toString());
            slices[i] = decimal;
        }
        return slices;
    }

    private static int hex_to_dec(String hex) {
        return Integer.parseInt(hex, 16);
    }

    private static char[] rotate(char[] lock) {
        char[] rotated = new char[lock.length];
        rotated[0] = lock[lock.length - 1];
        for (int i = 0; i < lock.length - 1; i++) {
            rotated[i + 1] = lock[i];
        }
        return rotated;
    }
}
