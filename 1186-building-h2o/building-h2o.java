import java.util.*;
import java.util.concurrent.*;

class H2O {

    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(1);

    private final CyclicBarrier barrier1 = new CyclicBarrier(3);
    private final CyclicBarrier barrier2 = new CyclicBarrier(3);

    public H2O() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hydrogen.acquire();

        try {
            barrier1.await();

            releaseHydrogen.run();

            barrier2.await();

        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        } finally {
            hydrogen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oxygen.acquire();

        try {
            barrier1.await();

            releaseOxygen.run();

            barrier2.await();

        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        } finally {
            oxygen.release();
        }
    }
}

