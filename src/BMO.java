 public class BMO extends BatteryRobot implements Runnable {
    boolean isQuiet;

    BMO() {
        super("BMO");
        isQuiet = false;
    }

    @Override
    public void run() {
        isQuiet = true;
        quietMode();
    }

    public void quietMode() {
        try {
            Thread.sleep(1000 * 30);
        } catch (InterruptedException e) {
            System.out.printf("\n[ERROR]: 스레드 예외처리 발생: %s\n", e.getMessage());
        } finally {
            if (powerStatus) {
                System.out.printf("\n[Robot: %s]: 저 이제 응답 하려고 하는데 괜찮죠?\n", name);
                System.out.print("선택: ");
            }

            isQuiet = false;
        }
    }

    public void fakeFarting() {
        if (useBattery(10)) {
            System.out.printf("[Robot: %s]: 부르륵 뿌뿌뿡! \uD83D\uDCA8 \uD83D\uDCA8 \uD83D\uDCA8 \n", this.name);
        }
    }

    public void playSong() {
        // 마지막으로 구현 해야 할 메서드 이지만 NEPTR에서 이미 비슷한 기능이 구현 돼 생략했습니다...
        System.out.printf("[Robot: %s]: 헤헤 노래는 잘 못부르는 걸요.!n", this.name);
    }

    @Override
    public void showCommand() {
        super.showCommand();
        System.out.print("1. 30초간 응답하지 않기\n");
        System.out.print("2. 가짜 방귀 소리\n");
        System.out.print("3. 노래 부르기\n");
        System.out.print("선택: ");
    }

    @Override
    public void action(int selectCommand) {
        if (!powerStatus) {
            System.out.printf("[System]: %s 전원을 먼저 켜주면 안될까요?\n", name);
            return;
        } else if (isQuiet) {
            System.out.printf("[System]: %s 응답이 없어요....\n", name);
            return;
        }

        switch (selectCommand) {
            case 1:
                if (!useBattery(1)) return;
                // quietMode(); 조용모드 실행
                System.out.printf("\n[Robot: %s]: 네... 몇초 정도는 조용히 있어볼게요.\n", name);
                Thread thread = new Thread(this);
                thread.start();
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
