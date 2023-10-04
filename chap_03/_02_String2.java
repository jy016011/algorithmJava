package chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s  = "I like Java and Python and C.";
        String s1 = s.replaceAll("and", ", ");
        System.out.println(s1);
        s1 = s.substring(s.indexOf("Java") , s.indexOf("Java") + "Java".length());
        System.out.println(s1);
        String s2 = "Java";
        String s3 = "Python" ;
        String s4 = s2 + s3;
        String s5 = "             I   LOVE       java        ";
        System.out.println(s5.trim());
        System.out.println(s4);
        System.out.println(s2.concat(s3));
    }
}
