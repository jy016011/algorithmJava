package chap_01;

public class _07_TypeCasting {
    public static void main(String[] args) {
        // 형변환 TypeCasting
        // 정수형에서 실수형으로
        int a = 99;
        double c = 98.1;
        int score = a + (int) 98.1;
        System.out.println(score);
        String str1 = Integer.toString(a);
        System.out.println(str1);
        String str2 = "1234" ;
        int b = Integer.parseInt(str2);
        System.out.println(b);
        score = 93 + (int) 98.8;
        System.out.println(score);
        String str3 = "98.9";
        double db = Double.parseDouble(str3);
        System.out.println(db);
        String str4 = Double.toString(db);
        System.out.println(str4);
        String str8 = "abcd" ;
        str8 += 1234;
        System.out.println(str8);
    }
}
