package prgrammers.highScoreKit.sort;

import java.util.Arrays;

public class _Q3_Lv3 {
    public static void main(String[] args) {
        _Q3_Lv3 solved = new _Q3_Lv3();
        int[] citations = {3, 0, 6, 1, 5};
        // answerr: 3
        System.out.println(solved.solution(citations) == 3);
        citations = new int[]{3, 4};
        // answer: 2
        System.out.println(solved.solution(citations) == 2);

    }

    public int solution(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        int hIndexLocation = -1;
        for (int i = 0; i < citations.length; i++) {
            int tempH = citations[i];
            if (citations.length - i >= tempH) {
                hIndex = Math.max(hIndex, tempH);
                hIndexLocation = i;
            }
        }
        if (hIndexLocation < citations.length - 1 && hIndexLocation >= 0) {
            for (int i = hIndex + 1; i < citations[hIndexLocation + 1]; i++) {
                if (i > citations.length - hIndexLocation - 1) {
                    break;
                }
                hIndex = i;
            }
        } else if (hIndexLocation == -1) {
            hIndex = citations.length;
        }
        return hIndex;
    }
}
