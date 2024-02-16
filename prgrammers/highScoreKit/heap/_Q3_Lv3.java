package prgrammers.highScoreKit.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _Q3_Lv3 {
    private static final char INSERT = 'I';
    private static final char DELETE = 'D';

    public static void main(String[] args) {
        _Q3_Lv3 solved = new _Q3_Lv3();
        String[] operations = {
                "I -45", "I 653", "D 1", "I -642",
                "I 45", "I 97", "D 1", "D -1",
                "I 333", "D -1", "D 1"
        };
        System.out.println(
                Arrays.toString(
                        solved.solution(operations)
                )
        ); // answer: [45, 45]

        operations = new String[]{
                "I -45", "I 653", "D 1", "I -642",
                "I 45", "I 97", "D 1", "D -1", "I 333"
        };
        System.out.println(
                Arrays.toString(
                        solved.solution(operations)
                )
        ); // answer: [333, -45]
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> ascPQ = new PriorityQueue<>();
        PriorityQueue<Integer> descPQ = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            char command = st.nextToken().charAt(0);
            if (command == INSERT) {
                int number = Integer.parseInt(st.nextToken());
                ascPQ.offer(number);
                descPQ.offer(number);
                continue;
            }
            if (command == DELETE) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1 && !descPQ.isEmpty()) {
                    int number = descPQ.poll();
                    ascPQ.remove(number);
                    continue;
                }
                if (type == -1 && !ascPQ.isEmpty()) {
                    int number = ascPQ.poll();
                    descPQ.remove(number);
                }
            }

        }

        if (ascPQ.isEmpty()) {
            return new int[]{0, 0};
        }
        while (!ascPQ.isEmpty()) {
            int number = ascPQ.poll();
            max = Integer.max(max, number);
            min = Integer.min(min, number);
        }
        return new int[]{max, min};
    }
}
