public class BMO extends Robot{
    private static int serialCount = 0;

    BMO() {
        super("BMO_" + serialCount++); // 여기에 BMO가 0부터 1씩 증가하는 순으로 자동적으로 네이밍이 되도록 하고 싶은데
    }

    public void quietMode(int sec) {
        if(!useBattery(1)){
            return;
        }
        System.out.printf("[Robot: %s]: 저는 %d 동안 응답 안해요! 안녕~\n", name, sec);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fakeFarting() {
        if(useBattery(5.0)){
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
