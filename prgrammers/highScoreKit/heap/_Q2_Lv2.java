package prgrammers.highScoreKit.heap;

import java.util.PriorityQueue;

public class _Q2_Lv2 {
    public static void main(String[] args) {
        _Q2_Lv2 solved = new _Q2_Lv2();
        int[][] jobs = {{1, 4}, {7, 9}, {1000, 3}};
        System.out.println(solved.solution(jobs)); //answer : 5
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        // buffer for jobs will get to schedule, sort by first: First Come First Served, second: Shortest Job First
        PriorityQueue<int[]> jobPq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int[] job : jobs) {
            jobPq.offer(job);
        }

        // schedule sort jobs by first: SJF, second: FCFS
        PriorityQueue<int[]> schedule = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        schedule.offer(jobPq.poll());
        int endTime = 0;

        while (!schedule.isEmpty()) {
            int[] job = schedule.poll();
            endTime = Math.max(endTime + job[1], job[0] + job[1]); // job come before end time or after
            answer += (endTime - job[0]);

            // for job come before endTime
            while (!jobPq.isEmpty()) {
                if (jobPq.peek()[0] <= endTime) {
                    schedule.offer(jobPq.poll());
                    continue;
                }
                break;
            }

            // for job come after endTime
            if (schedule.isEmpty() && !jobPq.isEmpty()) {
                schedule.offer(jobPq.poll());
            }
        }

        return answer / jobs.length; // avg served time, floor decimal place
    }
}
