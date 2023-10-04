package chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.indexOf("Java"));
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.replaceAll("Java",s.substring(7,11).toUpperCase()));
        System.out.println(s.contains("C"));
        System.out.println(s.indexOf("and"));
        System.out.println(s.lastIndexOf("and"));
        System.out.println(s.startsWith("I like"));
        System.out.println(s.startsWith("puthon"));
        System.out.println(s.endsWith("and C."));
        System.out.println(s.endsWith("javja"));
    }
}
