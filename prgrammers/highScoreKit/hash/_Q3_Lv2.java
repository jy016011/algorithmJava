package prgrammers.highScoreKit.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
프로그래머스 코딩테스트 고득점 kit 해시, 문제 3번: 전화번호 목록
 */
public class _Q3_Lv2 {
    public static void main(String[] args) {
        _Q3_Lv2 solved = new _Q3_Lv2();
        String[] phoneBook = {"12", "123", "1235", "567", "88"};
        System.out.println(solved.solution(phoneBook)); // answer: false
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phoneNumbers = new HashSet<>(Arrays.asList(phone_book));
        for (String number : phone_book) {
            phoneNumbers.remove(number);
            for (int i = 1; i <= number.length(); i++) {
                String subNumber = number.substring(0, i);
                if (phoneNumbers.contains(subNumber)) {
                    return false;
                }
            }
            phoneNumbers.add(number);
        }

        return answer;
    }
}
