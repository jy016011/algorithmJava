package chap_02;

public class _Quzi_02 {
    public static void main(String[] args) {
        int limit = 120;
        int height1 = 115;
        int height2 = 121;
        String valid1 = (height1 >= limit) ? "가능" : "불가능";
        String valid2 = (height2 >= limit) ? "가능" : "불가능";
        System.out.println("키가 " + height1 +  "cm 이므로 탑승 " + valid1 + "합니다.");
        System.out.println("키가 " + height2 +  "cm 이므로 탑승 " + valid2 + "합니다.");
    }
}
