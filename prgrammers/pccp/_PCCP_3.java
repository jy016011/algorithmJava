package prgrammers.pccp;

/*
    프로그래머스 PCCP 기출문제 3번: 아날로그 시계
*/

class _PCCP_3 {
    public static void main(String[] args) {
        _PCCP_3 solved = new _PCCP_3();
        // count of alarm in 00:00:00 ~ 23:59:59
        System.out.println(solved.solution(0, 0, 0, 23, 59, 59)); // answer: 2852
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer;
        int start = toSecond(h1, m1, s1);
        int end = toSecond(h2, m2, s2);
        answer = countAlarm(end) - countAlarm(start) + (isAlarm(start) ? 1
                : 0); // if start time cause alarm, should add one
        return answer;
    }

    private int countAlarm(int second) {
        // hour hand and second hand meet 719 times in 43,200 seconds(= 12 hours, one cycle of hour hand)
        int hourAlarm = second * 719 / 43_200;
        // minute hand and second hand meet 59 times in 3,600 seconds(= 60 minute, one cycle of minute hand)
        int minuteAlarm = second * 59 / 3_600;
        // at 0 o'clock and 12 o'clock hour, minute and second hand meet at the same time
        int doubleChecked = (second >= 43_200) ? 2 : 1;

        return hourAlarm + minuteAlarm - doubleChecked;
    }

    private int toSecond(int hour, int minute, int second) {
        minute += hour * 60;
        second += minute * 60;
        return second;
    }

    private boolean isAlarm(int second) {
        return second * 719 % 43_200 == 0 || second * 59 % 3_600 == 0;
    }
}
