package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q10815_S5_BinarySearch { // solved by using binary search.
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] cards = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        Arrays.sort(cards);
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] answer = new int[M];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(binarySearch(cards,target, 0, cards.length - 1)).append(" ");
        }
        System.out.println(stringBuilder);
    }
    public static int binarySearch(int[] cards, int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if (cards[mid] == target){
                return 1;
            } else if (cards[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return 0;
    }

}
