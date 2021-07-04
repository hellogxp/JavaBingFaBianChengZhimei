package Join;

/**
 * @Description: TODO
 * @Author chopin
 * @Date 2021/6/30 9:36 PM
 * @Version 1.0
 */
public class Join {

   public static void main(String[] args) {
      Thread threadA = new Thread(() -> {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName() + " output");
      });
      Thread threadB = new Thread(() -> {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         System.out.println(Thread.currentThread().getName() + " output");
      });
      threadA.start();
      threadB.start();

      System.out.println("Wait for all child threads end");
      try {
         threadA.join();
         threadB.join();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      System.out.println("Child threads end");

   }
}