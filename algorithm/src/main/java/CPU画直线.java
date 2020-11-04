import java.util.concurrent.*;

public class CPU画直线 {
    public static void main(String[] args) throws InterruptedException {
//        double second = 2.81 * Math.pow(10,9) * 4 / 5;
//        for(;;){
//            for (int i = 0; i < second; i++) {
//                Thread.sleep(10);
//            }
//        }

        int busyTime = 10;
        int idleTime = busyTime;
        long startTime;
        while (true) {
            startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime <= busyTime) {
                Thread.sleep(idleTime);
            }
        }
    }
}
