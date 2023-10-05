package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _Q10816_S4_BinarySearch { // solved by using binary search.
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
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(binarySearch(cards,target, 0, cards.length - 1)).append(" ");
        }
        System.out.println(stringBuilder);
    }
    public static int binarySearch(int[] cards, int target, int start, int end){
        int count = upperBound(cards, target, start, end) - lowerBound(cards, target, start, end);
        return count;
    }
    public static int upperBound(int[] cards, int target, int start, int end){
        int lo = start;
        int hi = end;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (target < cards[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static int lowerBound(int[] cards, int target, int start, int end){
        int lo = start;
        int hi = end;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (target <= cards[mid])
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

}
