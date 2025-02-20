package beakjoon.simulation.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class _Q13355_secondTry {
    private static class Truck {
        int weight, movedDistance;

        public Truck(int weight, int initDistance) {
            this.weight = weight;
            this.movedDistance = initDistance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // the number of trucks
        int w = Integer.parseInt(st.nextToken()); // the length of bridge
        int L = Integer.parseInt(st.nextToken()); // the maximum load of bridge
        Queue<Truck> trucks = new ArrayDeque<>(); // queue for trucks to move across the bridge

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.offer(new Truck(Integer.parseInt(st.nextToken()), 0));
        }

        Queue<Truck> bridge = new ArrayDeque<>();
        int currentWeight = L;
        int time = 0;
        // until both of the queues are empty
        while (!trucks.isEmpty() || !bridge.isEmpty()) {
            if (!trucks.isEmpty() && trucks.peek().weight <= currentWeight) {
                Truck truck = trucks.poll();
                bridge.offer(truck);
                currentWeight -= truck.weight;
            }

            for (Truck truck : bridge) {
                truck.movedDistance++;
            }
            time++;

            if (!bridge.isEmpty() && bridge.peek().movedDistance == w) {
                Truck truck = bridge.poll();
                currentWeight += truck.weight;
            }

        }
        System.out.println(time + 1);
    }
}
