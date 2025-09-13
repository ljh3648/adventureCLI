public class BatteryRobot extends Robot {
    private int batteryLevel;

    BatteryRobot(String name) {
        super(name);
        this.batteryLevel = 50;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void chargeBatteryLevel(int amount) {
        if (amount > 0) {
            this.batteryLevel += amount;

            if (this.batteryLevel > 100) {
                this.batteryLevel = 100;
            }
        }
    }

    public boolean useBattery(int amount) {
        if (batteryLevel - amount < 0) {
            System.out.printf("[Robot: %s]: 배터리가 부족하여 실행되지 못하고 전원이 종료됩니다.\n", name);

            batteryLevel = 0;
            powerOff();
            return false;
        }

        batteryLevel -= amount;
        return true;
    }

    @Override
    public void powerOn() {
        if (batteryLevel > 0) {
            super.powerOn();
        } else {
            System.out.printf("[Robot: %s]: 충전이 필요합니다.\n", name);
        }
    }

    @Override
    public void showStatus() {
        System.out.printf("[Robot: %s]: Power status: %s Battery level: %d\n", name, powerStatus ? "ON" : "OFF", batteryLevel);
    }
}