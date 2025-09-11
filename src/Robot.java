public class Robot {
    protected String name;
    protected boolean powerStatus;

    Robot(String name) {
        this.name = name;
        this.powerStatus = false;
        showStatus();
    }

    public void powerOn() {
        powerStatus = true;
    }

    public void powerOff() {
        powerStatus = false;
    }

    public void showStatus() {
        System.out.printf("[Robot: %s]: Power status: %s\n", name, powerStatus ? "ON" : "OFF");
    }

    public void showCommand() {
        System.out.printf("======= [Robot: %s] Command Menu =======\n", name);
        System.out.print("1. 전원 켬\n");
        System.out.print("2. 전원 끔\n");
    }
}
