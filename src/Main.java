import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Robot> robots = new ArrayList<>();
        robots.add(new BMO());
        robots.add(new NEPTR());

        System.out.print("Adventure CLI!\n");

        boolean isRunning = true;
        while(isRunning) {
            showMainMenu();

            int key = 0;
            key = sc.nextInt();

            switch (key){
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    isRunning = false;
                    System.out.print("[System]: 프로그램이 종료됩니다.\n");
                    break;
                default:
                    System.out.print("[System]: 잘못된 입력입니다.\n");
                    break;
            }
        }
    }

    public static void showMainMenu() {
        System.out.print("========= Main Menu ==========\n");
        System.out.print("1. 로봇 상태\n");
        System.out.print("2. 로봇 명령\n");
        // 로봇 명령에는 그 로봇이 할 수 있는 기능들만 표시하고
        // 기초적인 전원 관리 같은건 메인 메뉴에 빼둘까 고민되네
        System.out.print("0. CLI 프로그램 종료.\n");
        System.out.print("선택: ");
    }
}