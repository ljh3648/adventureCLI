public class Robot {
    public String name;
    protected boolean powerStatus;

    Robot(String name) {
        this.name = name;
        this.powerStatus = false;
        showStatus();
    }

    public void powerOn() {
        powerStatus = true;
        System.out.printf("[Robot: %s]: Power ON\n", name);
    }

    public void powerOff() {
        powerStatus = false;
        System.out.print("[Robot: %s]: Power OFF\n");
    }

    public void showStatus() {
        System.out.printf("[Robot: %s]: Power status: %s\n", name, powerStatus ? "ON" : "OFF");
    }

    public void showCommand() {
        System.out.printf("======= [Robot: %s] Command Menu =======\n", name);
    }

    public void action(int selectCommand){
    }

    public void showPowerControlMenu() {
        System.out.printf("======= [Robot: %s] Power Control Menu =======\n", name);
        System.out.print("1. 전원 켬\n");
        System.out.print("2. 전원 끔\n");
    }

    public void powerController(int selectCommand) {
        switch (selectCommand) {
            case 1:
                powerOn();
                break;
            case 2:
                powerOff();
                break;
            default:
                break;
        }
    }
}
