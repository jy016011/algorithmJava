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
        int K = 0;
        int speed = 1;
        while (K <= 500_000) {
            System.out.println("#" + (speed - 1) + ": " + K);
            K += speed;
            speed++;
        }
    }


}
