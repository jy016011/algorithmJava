package beakjoon.backTracking.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class _Q1759_G5 {
    private static final Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
    private static char[] chars;
    private static int L;
    private static StringBuilder stringBuilder;
    private static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        L = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        chars = new char[C];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        stringBuilder = new StringBuilder();
        map = new HashMap<>();
        map.put("consonant", 0);
        map.put("vowel", 0);
        for (int i = 0; i < C; i++) {
            chars[i] = stringTokenizer.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        backTracking(0, 0, new StringBuilder());
        System.out.println(stringBuilder);
    }

    private static void backTracking(int depth, int start, StringBuilder sequence) {
        if (depth == L) {
            if (map.get("vowel") >= 1 && map.get("consonant") >= 2) {
                stringBuilder.append(sequence).append(System.lineSeparator());
            }
            return;
        }

        for (int i = start; i < chars.length; i++) {
            if (isVowel(chars[i])) {
                map.put("vowel", map.get("vowel") + 1);
            } else {
                map.put("consonant", map.get("consonant") + 1);
            }
            sequence.append(chars[i]);
            backTracking(depth + 1, i + 1, sequence);
            sequence.setLength(sequence.length() - 1);
            if (isVowel(chars[i])) {
                map.put("vowel", map.get("vowel") - 1);
            } else {
                map.put("consonant", map.get("consonant") - 1);
            }
        }
    }

    private static boolean isVowel(char ch) {
        return vowels.contains(ch);
    }
}
