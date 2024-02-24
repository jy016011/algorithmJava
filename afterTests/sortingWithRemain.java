package afterTests;

import java.util.Arrays;
import java.util.PriorityQueue;

public class sortingWithRemain {
    public static void main(String[] args) {
        sortingWithRemain solved = new sortingWithRemain();
        int[] numbers = {2, 5, 6, 13, 14, 16, 35};
        System.out.println(Arrays.toString(solved.solution(numbers)));
    }

    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        boolean[] visited = new boolean[numbers[n - 1] + 1];
        PriorityQueue<Integer>[] pqArr = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            pqArr[i] = new PriorityQueue<>();
        }
        for (int number : numbers) {
            pqArr[number % n].offer(number);

        }
        int minIndex = -1;
        for (int remain = 0; remain < n; remain++) {
            if (!pqArr[remain].isEmpty()) {
                answer[remain] = pqArr[remain].poll();
                visited[answer[remain]] = true;
                continue;
            }
            for (int i = minIndex + 1; i < n; i++) {
                int index = numbers[i] % n;
                if (!visited[numbers[i]] && (pqArr[index].size() > 1 || index < remain)) {
                    visited[numbers[i]] = true;
                    answer[remain] = numbers[i];
                    pqArr[index].poll();
                    minIndex = i;
                    break;
                }
                minIndex = i;
            }
        }

        return answer;
    }
}
