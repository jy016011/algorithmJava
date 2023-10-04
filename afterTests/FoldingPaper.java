package afterTests;

import java.util.ArrayList;
import java.util.Arrays;
public class FoldingPaper {// solved by dfs. need to find any way to solve by using DP...
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
    static ArrayList<int[]> holes = new ArrayList<>(); // buffer of cutting after all folding is done.
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
        holes = newCuts; // first cut put in holes buffer
        int [] start = {1, 1};
        int [] end = {N, M};

        for(int i = 0; i < newCuts.size(); i++){
            int[] cut = newCuts.get(i);
            paper[cut[0]][cut[1]] = 0;
            getHoles(start, end, cut);
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                System.out.print(paper[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void getHoles(int[] start, int[] end, int[] cut){
        if (holes.size() >= (int)Math.pow(2,fold.length) * newCuts.size()){
            return;
        }
        for (int i = 0; i < fold.length; i++) {
            if(!visited[i]){ //paper will be folded (length of 'fold' - i)
                visited[i] = true;
                if (fold[i] == 1){ //folding left to right, will be the paper which has half column length.
                    int yMid = end[1] / 2;
                    int[] xy = {cut[0], end[1] - cut[1] + start[1]};
                    if(!isContain(xy)){ //List.contains() returns true when parameter is equal to object of List, that means address of memory is same, not its value.
                        paper[xy[0]][xy[1]] = 0;
                        holes.add(xy);
                    }
                    if (cut[1] > yMid){ // when col idx of current cut is over mid of col: idx in col of mid + 1 to end
                        int[] tmp = {end[0], yMid};
                        getHoles(start, tmp, xy); // travel to the other side. : travel to idx in col of start to mid
                        visited[i] = false;
                    }
                    else { // when col idx of current cut is under mid of col.: idx in col start ~ mid
                        int[] tmp = {start[0], yMid + 1};
                        getHoles(tmp, end, xy); // travel to the other side. : travel to idx in col mid ~ end
                        visited[i] = false;
                    }
                }
                else { //folding down to up, will be the paper which has half row length, all mechanisms will be worked equal to folding left to right.
                    int xMid = end[0] / 2;
                    int[] xy = {end[0] - cut[0] + start[0], cut[1]};
                    if(!isContain(xy)){
                        paper[xy[0]][xy[1]] = 0;
                        holes.add(xy);
                    }
                    if(cut[0] > xMid){
                        int[] tmp = {xMid, end[1]};
                        getHoles(start, tmp, xy);
                        visited[i] = false;
                    }
                    else {
                        int [] tmp = {xMid + 1, start[1]};
                        getHoles(tmp, end, xy);
                        visited[i] = false;
                    }
                }
            }
        }
    }
    public static boolean isContain(int[] items){ //Alter List.contain(): It returns boolean by comparing item's value
        for (int[] hole: holes
             ) {
            if(items[0] == hole[0] && items[1] == hole[1]){
                return true;
            }
        }
        return false;
    }
}