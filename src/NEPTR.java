public class NEPTR extends Robot{
    private double forgetToThrowPieChance;
    private static int serialCount = 0;

    NEPTR(){
        super("NEPTR_" + serialCount++);
        forgetToThrowPieChance = 0.1;
    }

    NEPTR(double forgetToThrowPieChance){
        this();
        this.forgetToThrowPieChance = forgetToThrowPieChance;
    }


    void throwPie() {
        // 배터리 on인 상태에서만 함수가 작동해야 하니까 체크하는게 필요할거 같은데.

        // 영원히 끝나지 않는 무한 반복문?
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
        // 그런데 확률에 따라서 파이를 던지는걸 까먹고 스레드가 종료되어야 함
    }

    @Override
    public void showCommand(){
        super.showCommand();
        System.out.print("4. 파이 던지기\n");
    }
}
