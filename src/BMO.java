public class BMO extends BatteryRobot{
    BMO() {
        super("BMO");
    }

    public void quietMode(int sec) {
        if(!useBattery(1)){
            return;
        }
        System.out.printf("[Robot: %s]: 저는 %d 동안 응답 안해요! 안녕~\n", name, sec);
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        System.out.print("4. 5분간 응답하지 않기\n");
        System.out.print("5. 가짜 방귀 소리\n");
        System.out.print("6. 노래 부르기\n");
    }

}
