package chap_04;

public class _Quiz_04 {
    public static void main(String[] args) {
        int chargePerH = 4000;
        int hour = 5;
        int charge = 0;
        final int MAXCHARGE = 30000;
        String typeOfCar = "경차";
        for (int i = 0; i < hour; i++) {
            charge += chargePerH;
            if (charge >= MAXCHARGE){
                charge = MAXCHARGE;
                break;
            }
        }
        if ((typeOfCar.equals("경차")) || (typeOfCar.equals("장애인 차량"))){
            charge /= 2;
        }
        System.out.println(charge);
    }
}
