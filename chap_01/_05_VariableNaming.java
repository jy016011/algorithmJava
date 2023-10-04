package chap_01;

public class _05_VariableNaming {
    public static void main(String[] args) {
        // 변수 이름 짓는법
        // 1. 저장할 값에 어울리는 임름
        // 2. 밑줄_, 문자abc, 숫자123 사용가능, 공백 사용불가
        // 3. 밑줄 또는 문자로 시작 가능
        // 4. 한 단어 또는 2개 이상 단어의 연속
        // 5. 소문자로 시작, 각 단어의 시작 글자는 대문자(첫단어 제외)
        // 6. 예약어 사용 불가(public, static, void, int, long ,float double등)

        // 입국 신고서(여행)
        String nationality = "RoK";
        String firstName = "JunYoung";
        String lastName = "Kim";
        String datOfBirth = "1998/02/04";
        String residentialAddress = "A Hotel";
        String purposeOfVisit = "tour";
        String flightNumber = "KE657";
        String _flightNumber = "KX657";
        String flight_no_2 = "KD657";

        // 절대 변하지 않는 상수는 대문자로
        final String CODE = "KR";
    }
}
