package chap_02;

public class _01_Operator1 {
    public static void main(String[] args) {
        System.out.println(5/2);
        System.out.println(2/4);
        System.out.println((double)5/2);
        System.out.println( 8 & 4);
        // 삼항 연산자
        // 결과 = 조건 ? 참의 경우 값 : 거짓의 경우 값
        System.out.println((3 > 1) ? 100: -100); // 100
        System.out.println((3 < 1) ? 100: -100); // -100
    }
}
