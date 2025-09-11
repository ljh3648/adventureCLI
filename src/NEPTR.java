public class NEPTR extends BatteryRobot{
    private double forgetToThrowPieChance;

    NEPTR(){
        super("NEPTR");
        forgetToThrowPieChance = 0.1;
    }

    NEPTR(double forgetToThrowPieChance){
        this();
        this.forgetToThrowPieChance = forgetToThrowPieChance;
    }


    void throwPie() {
        System.out.printf("[Robot: %s]: Never ending pie throwing ~~\n", name);

        while(true) {
            if(Math.random() < forgetToThrowPieChance) {
                System.out.printf("[Robot: %s]: 이 로봇은 파이를 던지는 것을 까먹었습니다.\n", name);
                break;
            }

            if(useBattery(1)) {
                System.out.printf("[Robot: %s]: \uD83E\uDD67 파이를 던지는 중\n", name);
            } else {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void showCommand(){
        super.showCommand();
        System.out.print("1. 파이 던지기\n");
        System.out.print("선택: ");
    }

    @Override
    public void action(int selectCommand) {
        if(powerStatus == false){
            System.out.printf("[Robot: %s]: 전원을 먼저 켜주면 안될까요?\n", name);
            return;
        }
        switch (selectCommand) {
            case 1:
                throwPie();
                break;
            default:
                break;
        }
    }
}
