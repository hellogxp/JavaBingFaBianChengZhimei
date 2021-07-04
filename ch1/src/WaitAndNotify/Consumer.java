package WaitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: TODO @Author chopin @Date 2021/6/29 9:46 AM @Version 1.0
 */
public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 3; i++) {
                int poll = queue.poll();
                System.out.println("Consume: " + poll);
                queue.notify();
            }
        }
    }
}
