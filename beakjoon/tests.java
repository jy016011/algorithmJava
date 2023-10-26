package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

// some simple tests while coding other works
public class tests {
    private static final int TEST = 1;
    private static final int TEST2 = 2;
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = list1;
        System.out.println(list1.equals(list2));
        list1.clear();
        System.out.println(list1);
        System.out.println(list2);
    }
}
