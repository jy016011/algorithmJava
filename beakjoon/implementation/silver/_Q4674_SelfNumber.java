package beakjoon.implementation.silver;

public class _Q4674_SelfNumber {
    public static void main(String[] args) {
        int[] numbers = new int[10036];
        for (int i = 1; i <= 10000; i++) {
            numbers[d(i)] = -1;
        }
        for (int i = 1; i < 10001; i ++){
            if(numbers[i] > -1){
                System.out.println(i);
            }
        }
    }
    public static int d(int n){
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i)- 48);
        }
        return n + sum;
    }
}
