package afterTests;

import java.util.ArrayList;
import java.util.Arrays;
public class FoldingPaperDp {// solved by DP
    static int [] fold = {1, -1, -1};
    static int[][] cuts = {{1, 1}, {2, 2}, {4, 4}};
    static int N = 8;
    static int M = 6;
//    static int [] fold = {1, 1};
//    static int[][] cuts = {{2, 1}, {4, 4}};
//    static int N = 4;
//    static int M = 4;
    static int[][] paper;
    static boolean[] visited;
    static int cnt = 0;
//    static ArrayList<int[]> holes = new ArrayList<>(); // buffer of cutting after all folding is done.
    static ArrayList<int[]> newCuts = new ArrayList<>(); // buffer of actual cutting
    public static void main(String[] args) {
        visited = new boolean[fold.length];
        paper = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(paper[i], 1);
        }
        int foldHeight = N;
        int foldWide = M;
        for(int act: fold){ // getting paper size after all folding
            if(act == 1) foldWide = foldWide / 2;
            else foldHeight = foldHeight / 2;
        }
        for(int[] cut: cuts){
            if(cut[0] > foldHeight || cut[1] > foldWide)
                continue;
            else newCuts.add(cut); // == if 'cut' in folded size, add actual cut
        }

        for (int[] cut : newCuts) {
            int[] start = {1, 1}; // params can be changed by below function call
            int[] end = {N, M}; // params can be changed by below function call
            getHoles(start, end, cut, 0); // after this call, 'start' or 'end' params can be changed...
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(cnt); // counting function calls: ( 2^(length of 'fold') * (length of 'newCuts') - (length of 'newCuts') )
    }
    public static void getHoles(int[] start, int[] end, int[] cut, int depth){
            paper[cut[0]][cut[1]] = 0;
            for (int i = depth; i < fold.length; i++) {
                if (!visited[i]) { //paper will be folded (length of 'fold' - i)
                    visited[i] = true;
                    if (fold[i] == 1) { //folding left to right, will be the paper which has half column length.
                        int yMid = (start[1] + end[1]) / 2;
                        int[] xy = {cut[0], end[1] - cut[1] + start[1]};
                        if (cut[1] > yMid) { // when col idx of current cut is over mid of col: idx in col of mid + 1 to end
                            int[] tmp = {end[0], yMid};
                            int s = start[0]; // without this, recursive will change parameter 'start'
                            getHoles(start, tmp, xy, depth + 1); // travel to the other side. : travel to idx in col of start to mid
                            cnt += 1;
                            start[0] = s;
                            start[1] = yMid + 1;
                        } else { // when col idx of current cut is under mid of col.: idx in col start ~ mid
                            int[] tmp = {start[0], yMid + 1};
                            int e = end[0]; // without this, recursive will change parameter 'end'
                            getHoles(tmp, end, xy, depth + 1); // travel to the other side. : travel to idx in col mid ~ end
                            cnt += 1;
                            end[0] = e;
                            end[1] = yMid;
                        }
                    } else { //folding down to up, will be the paper which has half row length, all mechanisms will be worked equal to folding left to right.
                        int xMid = (start[0] + end[0]) / 2;
                        int[] xy = {end[0] - cut[0] + start[0], cut[1]};
                        if (cut[0] > xMid) {
                            int[] tmp = {xMid, end[1]};
                            int s = start[1];// without this, recursive will change parameter 'start'
                            getHoles(start, tmp, xy, depth + 1);
                            cnt += 1;
                            start[0] = xMid + 1;
                            start[1] = s;
                        } else {
                            int[] tmp = {xMid + 1, start[1]};
                            int e = end[1];// without this, recursive will change parameter 'end'
                            getHoles(tmp, end, xy, depth + 1);
                            cnt += 1;
                            end[0] = xMid;
                            end[1] = e;
                        }
                    }
                    visited[i] = false;
                    depth += 1;
                }
            }
        }
}