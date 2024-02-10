package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// some simple tests while coding other works
public class tests {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String[] names = {"leo", "leo"};
        for (String name :
                names) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
                continue;
            }
            map.put(name, 1);
        }
        String leo = "leo";
        System.out.println(map.get(leo));
        int[][] test = new int[3][];
    }


}
