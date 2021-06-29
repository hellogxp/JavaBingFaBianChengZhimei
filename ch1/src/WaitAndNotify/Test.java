package WaitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/6/29 9:46 AM
 * @Version 1.0
 */
public class Test {
    private static Queue<Integer> queue = new LinkedList<>();
    private static final Integer MAX_NUM = 3;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        System.out.println("Consumer start waiting");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < MAX_NUM; i++) {
                    Integer poll = queue.poll();
                    System.out.println("Consume: " + poll);
                }
                queue.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (queue) {
                while (queue.size() == MAX_NUM) {
                    try {
                        System.out.println("Producer start waiting");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < MAX_NUM; i++) {
                    queue.add(i);
                    System.out.println("Produce: " + i);
                }
                queue.notify();
            }
        }).start();

    }
}