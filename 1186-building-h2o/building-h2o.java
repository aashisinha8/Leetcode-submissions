import java.util.*;
import java.util.concurrent.*;

class H2O {

    private final Semaphore hydrogen = new Semaphore(2);
    private final Semaphore oxygen = new Semaphore(1);

    private final CyclicBarrier barrier = new CyclicBarrier(3);

    public H2O() {
        // Code here
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hydrogen.acquire();

        try {
            barrier.await();

            releaseHydrogen.run();

            barrier.await();

        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        } finally {
            hydrogen.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oxygen.acquire();

        try {
            barrier.await();

            releaseOxygen.run();

            barrier.await();

        } catch (BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        } finally {
            oxygen.release();
        }
    }
}