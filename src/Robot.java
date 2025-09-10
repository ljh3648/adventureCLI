public class Robot {
    protected String name;
    private double batteryLevel;
    protected boolean powerStatus;

    Robot(String name) {
        this.name = name;
        this.batteryLevel = 100.0;
        this.powerStatus = false;
        showStatus();
    }

    public void powerOn() {
        powerStatus = true;
    }

    public void powerOff() {
        powerStatus = false;
    }

    public void charge(double amount) {
        batteryLevel += amount;
    }

    public boolean useBattery(double amount) {
        if(batteryLevel - amount < 0) {
            System.out.printf("[Robot: %s]: 배터리가 부족하여 실행되지 못하고 전원이 종료됩니다.\n", name);
            powerStatus = false;
            return false;
        }
        batteryLevel -= amount;
        return true;
    }

    public void showStatus() {
        System.out.printf("[Robot: %s]: PowerStatus: %s Battery Level: %f\n", name, powerStatus ? "ON" : "OFF", batteryLevel);
    }

    public void showCommand() {
        System.out.printf("======= [Robot: %s] Command Menu =======\n", name);
        System.out.print("1. 전원 켬\n");
        System.out.print("2. 전원 끔\n");
        System.out.print("3. 충전\n");
    }
}
