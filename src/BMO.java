public class BMO extends BatteryRobot implements Runnable {
    boolean isQuiet = false;

    BMO() {
        super("BMO");
    }
    // 파워가 켜져 있는 상태에서 애가 혼자 말해 일정 시간이 지날때마다
    // 근데 그걸 quietMode로 몇초간은 재울 수 있어
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000 * 5);
                if(powerStatus && !isQuiet) {
                    if(useBattery(1)){
                        System.out.printf("[Robot: %s]: 혼잣말 궁시렁 궁시렁.....\n", name);
                    }
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }


    public void quietMode() {
        if(!useBattery(1)){
            return;
        }
        isQuiet = true;
        System.out.printf("[Robot: %s]: 네... 몇초 정도는 조용히 있어볼게요.\n", name);
        try {
            Thread.sleep(1000 * 30);
        } catch (InterruptedException e) {
            isQuiet = false;
            return;
        }
        isQuiet = false;
    }

    public void fakeFarting() {
        if(useBattery(5)){
            System.out.printf("[Robot: %s]: poot! \uD83D\uDCA8 \uD83D\uDCA8 \uD83D\uDCA8 \n", name);
        }
    }

    public void playSong() {
        //노래 재생 시간마다 한 줄 씩 부르는거 괜찮은 듯
    }

    @Override
    public void showCommand(){
        super.showCommand();
        System.out.print("1. 10초간 응답하지 않기\n");
        System.out.print("2. 가짜 방귀 소리\n");
        System.out.print("3. 노래 부르기\n");
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
                quietMode();
                break;
            case 2:
                fakeFarting();
                break;
            case 3:
                playSong();
                break;
            default:
                break;
        }
    }
}
