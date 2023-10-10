package beakjoon.stackQueueDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _Q4949_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> characterStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (true){
            char[] charArray = bufferedReader.readLine().toCharArray();
            boolean isVps = true;
            if (charArray[0] == '.')
                break;
            for (char character: charArray) {
                if (character == '(' || character == '['){
                    characterStack.push(character);
                } else if (character == ')') {
                    if (!characterStack.isEmpty()) {
                        if (characterStack.pop() != '(') {
                            isVps = false;
                            break;
                        }
                    }
                    else {
                        isVps = false;
                        break;
                    }
                } else if (character == ']') {
                    if (!characterStack.isEmpty()) {
                        if (characterStack.pop() != '[') {
                            isVps = false;
                            break;
                        }
                    }
                    else {
                        isVps = false;
                        break;
                    }
                }
            }
            if (!characterStack.isEmpty())
                isVps = false;
            if (isVps)
                stringBuilder.append("yes").append("\n");
            else
                stringBuilder.append("no").append("\n");
            characterStack.clear();
        }
        System.out.println(stringBuilder);
    }
}
