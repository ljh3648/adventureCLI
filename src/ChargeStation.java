public class ChargeStation implements Runnable {
    private boolean isBusy;
    private BatteryRobot chargingRobot;

    ChargeStation() {
        isBusy = false;
        chargingRobot = null;
    }

    @Override
    public void run() {
        try {
            while (chargingRobot.getBatteryLevel() < 100) {
                chargingRobot.chargeBatteryLevel(1);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.printf("\n[ERROR]: 스레드 예외처리 발생: %s", e.getMessage());
        } finally {
            System.out.printf("\n[System]: %s 충전이 끝났습니다.\n", chargingRobot.name);
            System.out.print("선택: ");

            isBusy = false;
        }
    }

    public void charge(Robot robot) {
        if (!(robot instanceof BatteryRobot)) {
            System.out.print("[System]: 이 로봇은 배터리로 작동하지 않습니다.\n");
            return;
        } else if (isBusy) {
            System.out.print("[System]: 현재 배터리 충전소는 바쁩니다.\n");
            return;
        }

        isBusy = true;
        chargingRobot = (BatteryRobot) robot;

        System.out.printf("[System]: %s 충전을 시작합니다.\n", chargingRobot.name);
        Thread thread = new Thread(this);
        thread.start();
    }
}
