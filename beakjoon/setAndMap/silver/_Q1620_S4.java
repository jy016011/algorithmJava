package beakjoon.setAndMap.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _Q1620_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        HashMap<String, Integer> pokemonDict = new HashMap<>();
        String[] pokemon = new String[N + 1];
        for (int i = 1; i < N + 1; i++) {
            String name = bufferedReader.readLine();
            pokemonDict.put(name, i);
            pokemon[i] = name;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = bufferedReader.readLine();
            if (input.charAt(0) >= 65)
                stringBuilder.append(pokemonDict.get(input)).append("\n");
            else
                stringBuilder.append(pokemon[Integer.parseInt(input)]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
