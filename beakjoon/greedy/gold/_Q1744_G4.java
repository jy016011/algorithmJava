package beakjoon.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _Q1744_G4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Integer> naturalNumbers = new ArrayList<>();
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int integer = Integer.parseInt(bufferedReader.readLine());
            if (integer > 0)
                naturalNumbers.add(integer);
            else
                negativeNumbers.add(integer);
        }
        naturalNumbers.sort(Comparator.reverseOrder());
        negativeNumbers.sort(Comparator.naturalOrder());
        int sumNaturals = 0;
        for (int i = 0; i < naturalNumbers.size(); i += 2) {
            if (i == naturalNumbers.size() - 1) {
                sumNaturals += naturalNumbers.get(i);
                break;
            }
            int add = naturalNumbers.get(i) + naturalNumbers.get(i + 1);
            int multi = naturalNumbers.get(i) * naturalNumbers.get(i + 1);
            sumNaturals += Math.max(add, multi);
        }
        int sumNegatives = 0;
        for (int i = 0; i < negativeNumbers.size(); i += 2) {
            if (i == negativeNumbers.size() - 1){
                sumNegatives += negativeNumbers.get(i);
                break;
            }
            sumNegatives += negativeNumbers.get(i) * negativeNumbers.get(i + 1);
        }
        System.out.println(sumNaturals + sumNegatives);
    }
}
