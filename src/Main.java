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
            Robot robot = null;

            switch (key){
                case 1:
                    showStatusRobots(robots);
                    break;
                case 2:
                    robot = selectRobots(sc, robots);
                    robot.showPowerControlMenu();
                    int selectPowerCommand = sc.nextInt();
                    robot.powerController(selectPowerCommand);
                    break;
                case 3:
                    robot = selectRobots(sc, robots);
                    robot.showCommand();
                    int selectCommand = sc.nextInt();
                    robot.action(selectCommand);
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
        System.out.print("2. 로봇 전원 관리\n");
        System.out.print("3. 로봇 명령\n");
        System.out.print("0. CLI 프로그램 종료.\n");
        System.out.print("선택: ");
    }

    public static void showStatusRobots(List<Robot> robots) {
        for(Robot robot : robots) {
            robot.showStatus();
        }
    }

    public static Robot selectRobots(Scanner sc, List<Robot> robots){
        System.out.print("========= Select Robot Menu ==========\n");
        System.out.print("1. BMO\n");
        System.out.print("2. NEPTR\n");
        System.out.print("선택: ");

        int index = sc.nextInt();

        // 잘못된 로봇을 선택하면 다시 선택 기능 추가 필요

        return robots.get(index - 1);
    }
}