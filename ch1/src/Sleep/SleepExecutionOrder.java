package Sleep;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chopin
 * @version 1.0
 * @description: The execution order of threads A and B will not change, and B will be executed after the execution of A
 * is completed. Because after a thread calls the sleep method, the calling thread will temporarily give up the right to
 * execute the time, that is, it will not participate in the scheduling of the CPU, but it will not release the monitor
 * resources it owns.
 * @date 2021/7/14 21:34
 */
public class SleepExecutionOrder {
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("ThreadA gonna sleep");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("ThreadA was awakened");
            }
        });

        Thread threadB = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("ThreadB gonna sleep");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("ThreadB was awakened");
            }
        });

        threadA.start();
        threadB.start();
    }
}