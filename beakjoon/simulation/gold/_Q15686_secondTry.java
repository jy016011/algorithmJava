package beakjoon.simulation.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _Q15686_secondTry {
    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node> chickens = new ArrayList<>(); // 모든 치킨집의 위치 좌표 저장
        List<Node> houses = new ArrayList<>(); // 모든 집의 위치 좌표 저장

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int element = Integer.parseInt(st.nextToken());
                if (element == 1) {
                    houses.add(new Node(i, j));
                } else if (element == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        List<Node> pickedChickens = new ArrayList<>();
        pickChickens(0, 0, M, chickens, houses, pickedChickens);
        System.out.println(answer);
    }

    private static void pickChickens(int depth, int start, int M, List<Node> chickens, List<Node> houses,
                                     List<Node> pickedChickens) {
        if (depth == M) {
            calDistance(pickedChickens, houses);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            pickedChickens.add(chickens.get(i));
            pickChickens(depth + 1, i + 1, M, chickens, houses, pickedChickens);
            pickedChickens.remove(pickedChickens.size() - 1);
        }
    }

    private static void calDistance(List<Node> pickedChickens, List<Node> houses) {
        int townDistSum = 0;
        for (Node house : houses) {
            int chickenDistance = Integer.MAX_VALUE;
            for (Node chicken : pickedChickens) {
                int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                chickenDistance = Math.min(chickenDistance, distance);
            }
            townDistSum += chickenDistance;
        }
        answer = Math.min(townDistSum, answer);
    }
}
