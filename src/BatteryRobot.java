public class BatteryRobot extends Robot {
    private int batteryLevel;

    BatteryRobot(String name) {
        super(name);
        this.batteryLevel = 100;
    }

    public void charge(int amount) {
        batteryLevel += amount;
    }

    public boolean useBattery(int amount) {
        if(batteryLevel - amount < 0) {
            System.out.printf("[Robot: %s]: 배터리가 부족하여 실행되지 못하고 전원이 종료됩니다.\n", name);
            powerStatus = false;
            return false;
        }
        batteryLevel -= amount;
        return true;
    }
    @Override
    public void showStatus() {
        System.out.printf("[Robot: %s]: Power status: %s Battery level: %d\n", name, powerStatus ? "ON" : "OFF", batteryLevel);
    }

    @Override
    public void showCommand() {
        super.showCommand();
        System.out.print("3. 배터리 충전\n");
    }
}