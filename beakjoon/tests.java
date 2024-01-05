package beakjoon;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// some simple tests while coding other works
public class tests {
    private static final int TEST = 1;
    private static int TEST2;
    static List<Integer> test1;

    public static void main(String[] args) throws IOException {
        List<LocalDate> days = new ArrayList<>();
        days.add(LocalDate.of(2023, 12, 1));
        LocalDate visitDay = LocalDate.of(2023, 12, 1);
        System.out.println(days.contains(visitDay));
        System.out.println((char) (1 + '0'));
    }


}
