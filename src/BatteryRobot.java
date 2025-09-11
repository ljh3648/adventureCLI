public class BatteryRobot extends Robot {
    private int batteryLevel;

    BatteryRobot(String name) {
        super(name);
        this.batteryLevel = 100;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.printf("[Robot: %s]: 배터리를 충전이 완료되었습니다.\n", name);
    }

    public boolean useBattery(int amount) {
        if(batteryLevel - amount < 0) {
            System.out.printf("[Robot: %s]: 배터리가 부족하여 실행되지 못하고 전원이 종료됩니다.\n", name);
            powerOff();
            return false;
        }
        batteryLevel -= amount;
        return true;
    }

    @Override
    public void powerOn() {
        if(batteryLevel > 0) {
            super.powerOn();
        } else {
            System.out.printf("[Robot: %s]: 충전이 필요합니다.\n", name);
        }
    }

    @Override
    public void showStatus() {
        System.out.printf("[Robot: %s]: Power status: %s Battery level: %d\n", name, powerStatus ? "ON" : "OFF", batteryLevel);
    }

    @Override
    public void showPowerControlMenu() {
        super.showPowerControlMenu();
        System.out.print("3. 배터리 충전\n");
    }

    @Override
    public void powerController(int selectCommand) {
        switch (selectCommand) {
            case 3:
                chargeBattery();
                break;
            default:
                super.powerController(selectCommand);
                break;
        }
    }
}