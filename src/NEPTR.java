public class NEPTR extends BatteryRobot {
    private double forgetToThrowPieChance;

    NEPTR() {
        super("NEPTR");
        forgetToThrowPieChance = 0.07;
    }

    void throwPie() {
        try {
            while (!(Math.random() < forgetToThrowPieChance)) {
                if (!useBattery(5)) return;

                System.out.printf("[Robot: %s]: \uD83E\uDD67 파이를 던지는 중\n", name);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.printf("\n[ERROR]: 스레드 예외처리 발생: %s", e.getMessage());
        } finally {
            System.out.printf("\n[Robot: %s]: 내가 뭐 하려고 했는지 기억나시나요?\n", name);
        }
    }

    @Override
    public void showCommand() {
        super.showCommand();
        System.out.print("1. 파이 던지기\n");
        System.out.print("선택: ");
    }

    @Override
    public void action(int selectCommand) {
        if (!powerStatus) {
            System.out.printf("[System]: %s 전원을 먼저 켜주면 안될까요?\n", name);
            return;
        }

        switch (selectCommand) {
            case 1:
                System.out.printf("[Robot: %s]: Never ending pie throwing ~~\n", name);
                throwPie();
                break;
            default:
                break;
        }
    }
}
