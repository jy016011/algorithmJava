package chap_04;

public class _04_SwitchCase {
    public static void main(String[] args) {
        // Swtich cases

        // 석차에 따른 장학금 지급
        // 1등: 전액
        // 2등: 반액
        // 3등: 쿼터
        // 그외: 장학금 대상 아님
        String rank = "4등";

        switch (rank) {
            case "1등":
                System.out.println("전액 장학금");
                break;
            case "2등":
                System.out.println("반액");
                break;
            case "3등":
                System.out.println("쿼터");
                break;
            default:
                System.out.println("장학금 못받쥬~");
        }

    }
}
