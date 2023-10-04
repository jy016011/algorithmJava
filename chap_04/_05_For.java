package chap_04;

public class _05_For {
    public static void main(String[] args) {
        // for
        for ( int i = 0; i < 10; ++i ){
            System.out.println(i);
        }
        for (int i = 0; i < 10; i += 2) {
            System.out.println(i);
        }
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        int sum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
