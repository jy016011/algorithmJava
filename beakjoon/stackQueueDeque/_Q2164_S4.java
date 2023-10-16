package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _Q2164_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
                cards.offer(i);
        }
        while (cards.size() > 1) {
            cards.poll();
            cards.offer(cards.poll());
        }
        System.out.println(cards.peek());
    }
}