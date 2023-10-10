package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _Q9012_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> psStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char[] parenthesis = bufferedReader.readLine().toCharArray();
            boolean isVps = true;
            for (char p: parenthesis) {
                if (p == '(')
                    psStack.push(p);
                else if (p == ')') {
                    if (!psStack.isEmpty())
                        psStack.pop();
                    else {
                        isVps = false;
                        break;
                    }
                }
            }
            if (!psStack.isEmpty())
                isVps = false;
            if (isVps)
                stringBuilder.append("YES").append("\n");
            else
                stringBuilder.append("NO").append("\n");
            psStack.clear();
        }
        System.out.println(stringBuilder);
    }
}
