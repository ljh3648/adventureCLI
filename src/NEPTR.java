public class NEPTR extends BatteryRobot {
    private boolean isBusy = false;
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
        isBusy = true;

        while(true) {
            if(Math.random() < forgetToThrowPieChance) {
                try {
                    System.out.printf("\n[Robot: %s]: 음...\n", name);
                    Thread.sleep(700);
                    System.out.printf("\n[Robot: %s]: 내가 뭐하고 있더라...\n", name);
                    Thread.sleep(2000);
                    System.out.printf("\n[Robot: %s]: 으으음...\n", name);
                    Thread.sleep(1000);
                    System.out.printf("\n[Robot: %s]: 음..\n", name);
                    Thread.sleep(2000);
                    System.out.printf("\n[Robot: %s]: 이제 뭐하지 ?\n", name);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

            if(useBattery(5)) {
                System.out.printf("\n[Robot: %s]: \uD83E\uDD67 파이를 던지는 중\n", name);
            } else {
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        isBusy = false;
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
