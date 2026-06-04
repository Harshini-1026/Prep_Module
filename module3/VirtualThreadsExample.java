public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        int virtualCount = 100_000;

        long virtualStart = System.nanoTime();
        Thread[] virtualThreads = new Thread[virtualCount];

        for (int i = 0; i < virtualCount; i++) {
            virtualThreads[i] = Thread.startVirtualThread(() -> { });
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }

        long virtualTime = System.nanoTime() - virtualStart;

        int platformCount = 1_000;
        long platformStart = System.nanoTime();
        Thread[] platformThreads = new Thread[platformCount];

        for (int i = 0; i < platformCount; i++) {
            platformThreads[i] = new Thread(() -> { });
            platformThreads[i].start();
        }

        for (Thread thread : platformThreads) {
            thread.join();
        }

        long platformTime = System.nanoTime() - platformStart;

        System.out.println("Virtual threads time (ns): " + virtualTime);
        System.out.println("Platform threads time (ns): " + platformTime);
    }
}