package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.w3c.dom.ls.LSOutput;

// some simple tests while coding other works
public class tests {
    private static final int TEST = 1;
    private static int TEST2;
    static List<Integer> test1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        List<String> numbers = toTrimmedStringList(input, ",");
        System.out.println(numbers.size());
        System.out.println(numbers.get(0).length());
    }

    public static List<String> toTrimmedStringList(String input, String separator) {
        return Arrays.stream(
                        input.split(separator, -1))
                .map(String::trim).collect(Collectors.toList()
                );
    }
}
