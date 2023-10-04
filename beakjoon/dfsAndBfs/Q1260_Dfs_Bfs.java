package beakjoon.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260_Dfs_Bfs {
    static int N, M, startN;
    static boolean[] visited;
    static int[][] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startN = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        dfs(startN);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(startN);
        System.out.println(sb);
        //bw.write(sb.toString());

    }
    public static void dfs(int start){
        visited[start] = true;
        sb.append(start).append(" ");
        for(int i = 1; i < graph[start].length; i++){
            if((!visited[i]) && (graph[start][i] == 1)){
                dfs(i);
            }
        }
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        sb.append(start).append(" ");
        q.offer(start);
        while (!q.isEmpty()){
            int visitedNode = q.poll();
            for(int adjIdx = 1; adjIdx < graph[visitedNode].length; adjIdx ++){
                if((graph[visitedNode][adjIdx] == 1) && !visited[adjIdx]){
                    visited[adjIdx] = true;
                    sb.append(adjIdx).append(" ");
                    q.offer(adjIdx);
                }
            }
        }
    }
}


