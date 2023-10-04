package chap_04;

public class _06_While {
    public static void main(String[] args) {
        int distance = 25;
        int move = 2;
        while (distance > 0){
            System.out.println("moved "+move+"m "+distance+"m left");
            distance -= move;
        }
        distance = 25;
        do {
            System.out.println(distance);
            distance -= move;
        } while (distance > 0);


    }
}
