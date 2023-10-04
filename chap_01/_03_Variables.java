package chap_01;

import java.lang.reflect.Type;

public class _03_Variables {
    public static void main(String[] args) {
        String name ;
        name = "김준영";
        int time = 10;
        System.out.println(name + "님 " + time + "시에 오세요");

        double score = 90.5;
        float pi = 3.14F;
        char grade = 'A';
        name = "강백호";
        System.out.println(name + "님의 평균 점수는 " + score + "점입니다.");
        System.out.println("학점은 " + grade + "입니다.");
        long i;
        i = 1000_000_000L;
        System.out.println(i);

        String str1 = "123";
        int j = Integer.parseInt(str1);
        String str2 = Integer.toString(j);
        System.out.println(((Integer)j).getClass().getName());
        System.out.println(str2.getClass().getName());
    }
}
