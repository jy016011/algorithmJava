package chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Python";
        System.out.println(s1.equals(s2)); // s1 == s2
        System.out.println(s2.equalsIgnoreCase("PYTHON"));

        s1 = "1234"; // 1234값을 메모리에 할당
        s2 = "1234"; // 1234 값 할당 안함, s1의 메모리 주소만 참조
        System.out.println(s1.equals(s2)); // true(내용바교)
        System.out.println(s1 == s2); // true(같은것을 참조하는지)

        s1 = new String("1234"); // 1234값을 s1의 메모리에 할당
        s2 = new String("1234"); // 1234값을 s2의 메모리에 새로 할당

        System.out.println(s1.equals(s2)); // true(내용비교)
        System.out.println(s1 == s2); // false(같은 것을 참조하는지)
    }
}
