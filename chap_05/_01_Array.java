package chap_05;

public class _01_Array {
    public static void main(String[] args) {
        String str = "COFFEE";
        System.out.println(str.length());
        String[] coffees = {"Americano", "cafe mocha", "cafe latte", "cappuccino"};
        System.out.println(coffees.length);
        for (int i = 0; i < coffees.length; i++) {
            System.out.println(coffees[i]);
        }

    }
}
