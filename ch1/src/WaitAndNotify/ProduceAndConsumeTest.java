package WaitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

/** @Description: TODO @Author chopin @Date 2021/6/29 11:43 PM @Version 1.0 */
public class ProduceAndConsumeTest {
  private static final Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) {
    Producer producer = new Producer();
    producer.setQueue(queue);
    Consumer consumer = new Consumer();
    consumer.setQueue(queue);
    while (true) {
      new Thread(producer).start();
      new Thread(consumer).start();
      try {
        Thread.sleep(2000);
        System.out.println("=======");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
